'use strict';
angular.module('hmModule').controller("StateController", function($localStorage,$rootScope, $scope,$state,urls,StateService,GetPostService) 
{
	//console.log('State Controller called');
	//console.log($state.current.name);
	//var currentPageState=newStateManager();
	//console.log(currentPageState);
	$scope.courseSelected=$state.current.name;
	$scope.tabsArray=[];
	$scope.getSpecificPlaylist=function(playlistname)
	{
		console.log(playlistname);
		$rootScope.playlistname=playlistname;
		$localStorage.playlistname=playlistname;
		$state.transitionTo('watch');
		
	};
	
   GetPostService.getCall(urls.COURSE_API+$state.current.name)
	.then(
            function (mainResponse) 
            {
            	
            	$scope.tabsArray.subjects=[];
            	//console.log(StateService.getState(mainResponse._embedded.state["0"]._links.tabs.href));
            	if(mainResponse)
            		{
            		GetPostService.getCall(mainResponse.data._links.subjects.href)
                	.then(
                            function (response) 
                            {
                            	//$scope.tabsArray=response.data._embedded.tabs;
                            	//console.log(response);
                            	$scope.tabsArray.subjects=response.data._embedded.subjects
                            	getSubjectsInternalData($scope.tabsArray.subjects);
                            	console.log($scope.tabsArray.subjects);
                            },
                            function (errResponse)
                            {    
                                console.log(errResponse);
                                
                            }
                          );
            		}
            	
            	
            	
            	
            },
            function (errResponse)
            {    
                console.log("error");
            }
          );

		   function getSubjectsInternalData(Outerresponse)
		   {
			  // $scope.tabsArray.subjects.classes=[];
			  $.each(Outerresponse, function( i, value ) 
			  {
			  	GetPostService.getCall(value._links.className.href)
                	.then(
                            function (response) 
                            {
                            	console.log(response);
                            	//creating classes
                            	Outerresponse[i].classes=[];
                            	Outerresponse[i].classes=response.data._embedded.classes;
                            	getchapOrUniveristy(Outerresponse[i].classes);
                            	console.log($scope.tabsArray);
                            },
                            function (errResponse)
                            {    
                                console.log(errResponse);
                                
                            }
                          );
			  });
		   }
		   function getchapOrUniveristy(Outerresponse)
		   {
			
			   $.each(Outerresponse, function( i, value ) 
						  {
				   GetPostService.getCall(value._links.chapteroruniversity.href)
	             	.then(
	                         function (response) 
	                         {
	                         	console.log(response);
	                         	Outerresponse[i].chapOrUniveristy=[];
	                         	Outerresponse[i].chapOrUniveristy=response.data._embedded.chap_university;
	                         	
	                        	// chapOrUniveristy=response.data._embedded.chapteroruniversity;
	                        	// getPlaylists(Outerresponse[i].chapOrUniveristy);
	                         },
	                         function (errResponse)
	                         {    
	                             console.log(errResponse);
	                             
	                         }
	                       );
						  });
			   
			 
		   }
		   function getPlaylists(Outerresponse)
		   {
			   
			   $.each(Outerresponse, function( i, value ) 
			   {
				   GetPostService.getCall(value._links.playlists.href)
	            	.then(
	                        function (response) 
	                        {
	                        	console.log(response);
	                         	Outerresponse[i].playlists=[];
	                         	Outerresponse[i].playlists=response.data._embedded.playlists;

	                        },
	                        function (errResponse)
	                        {    
	                            console.log(errResponse);
	                            
	                        }
	                      );
			   });
						  
			   
		   }
		   
		   
		   
			
	
});



/*/sb/state/search/findBystatename?statename*/