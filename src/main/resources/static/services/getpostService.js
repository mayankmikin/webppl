'use strict';
angular.module('hmModule').factory('GetPostService',
    ['$localStorage','$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) 
        {

            var factory = 
            {
                postCall:postCall,
                getCall:getCall,
                login:login 
            };

            return factory;
    function postCall(urL,jsondata,)
    {
    	 
    var deferred = $q.defer();
     $http.post(urL, jsondata,{headers:{'Content-Type': 'application/json'}}).success(function (response) 
     {
        //console.log(response.token);
        //$localStorage.headers='Bearer ' + response.token;
        //$http.defaults.headers.common.Authorization = 'Bearer ' + response.token;
       // $http.defaults.headers.common['Authorization'] = 'Bearer ' + response.token;
     })
     .then(
            function (response) 
            {
                deferred.resolve(response);
            },
            function (errResponse)
            {    
                deferred.reject(errResponse);
            }
          );
    return deferred.promise;
    }
    

    function getCall(urL,param)
    {              
      if(param)
      {
         return $http.get(urL,param).success(function(response)
            {
                console.log(response);
                return response;
            });
      }
          return $http.get(urL).success(function(response)
          {
                console.log(response);
                return response;
            });
      
        
    }
    
    function login(url,jsondata)
    {
     return $http.post(url, jsondata).success(function(data, status, headers, config) 
      {
                console.log(data);
                $http.defaults.headers.common.Authorization = data;
                $localStorage.headers=data;
                return data;

      });
    }

  }

]);

