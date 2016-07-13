(function(){
var signUpService = function($http, $q){
	return ({
		createUser : createUser
	});
	
	function createUser(data){
		return $http.post('http://localhost:8080/movieflex/users',data).then(handleSuccess,handleError)
		
		
	}
	
	
	function handleError(response) {
		if (!angular.isObject(response.data) || !response.data.message) {
			return ($q.reject("An unknown error occurred."));
		}
		return ($q.reject(response.data.message));
	}

	function handleSuccess(response) {
		return (response.data);
	}
};
angular.module('movieFlex').service('signUpService',signUpService);
}());