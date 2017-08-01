'use strict';
angular.module('hmModule').controller("VpanelController", function ($localStorage,$scope, $rootScope, $stateParams, $state, $location, $window,$timeout,$sce,context,urls,GetPostService,ngYoutubeEmbedService) 
{
	console.log("playlist to show is :");
	$scope.videoObjects=[];
	$scope.currentVideo=
	{
			url:"",
			name:""
	};
	$scope.playlistname="";
	var url=urls.PLAYLIST_GET_API;
				if($rootScope.playlistname)
        		{
					url+=$rootScope.playlistname;
					$scope.playlistname=$rootScope.playlistname;
        		}
				else
        		{
					url+=$localStorage.playlistname;
					$scope.playlistname=$localStorage.playlistname;
        		}
				
		//	console.log($scope.playlistname.split("_"));
			var temparr=$scope.playlistname.split("_");
			$scope.coursename=temparr[0];
			$scope.subjectname=temparr[1];
			$scope.semester=temparr[2];
			$scope.university=temparr[3];
			//0 coursename
			//1 subjectname
			//2 semester
			//3 university
			GetPostService.getCall(url)
        	.then(
                    function (response) 
                    {
                    	console.log(response);
                    	getVideos(response);
                    	//creating classes
                    	
                    },
                    function (errResponse)
                    {    
                        console.log(errResponse);
                        
                    }
                  );
        
    		function getVideos(Outerresponse)
    		{
    			
    			GetPostService.getCall(Outerresponse.data._links.videos.href)
    	    	.then(
    	                function (response) 
    	                {
    	                	//console.log(response);	
    	                	$scope.videoObjects=response.data._embedded.videos;
    	                	$scope.currentVideo.url=$scope.videoObjects["0"].url_name;
    	                	$scope.currentVideo.name=$scope.videoObjects["0"].video_name;
    	                },
    	                function (errResponse)
    	                {    
    	                    console.log(errResponse);
    	                    
    	                }
    	              );
    		};
    		$scope.setVideo=function(index)
    		{
    			console.log(index);
    			$scope.currentVideo.url=$scope.videoObjects[index].url_name;
            	$scope.currentVideo.name=$scope.videoObjects[index].video_name;
    		};
            

	});