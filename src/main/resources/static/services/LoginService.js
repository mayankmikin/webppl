'use strict';

angular.module('hmModule').factory('LoginService',
    ['$localStorage','$cookieStore','$http', '$q','$rootScope','GetPostService', 'urls',
        function ($localStorage,$cookieStore, $http, $q, urls,$rootScope,GetPostService) 
        {

            var factory = 
            {
                login : login ,
                setVariables:setVariables,
                logout:logout
            };

            return factory;

            function login(user,curl)
            {
                console.log(urls.USER_LOGIN_API);
            	var apiResponse;
                 apiResponse=GetPostService.postCall(curl,user);
                return apiResponse;

            }

            function setVariables(response)
            {

                $rootScope.userProp=response;
                $rootScope.isUserLoggedIn=true;
                $cookieStore.put('userstore',response);
                $cookieStore.put('isLoggedIn','true');

            }
            function logout()
            {
                
                delete $rootScope.userProp;
                delete $rootScope.isUserLoggedIn;
                delete $localStorage.headers;
            $http.defaults.headers.common.Authorization = '';
                $cookieStore.put('userstore','');
                $cookieStore.put('isLoggedIn','false');
                
            }
            

        }]);