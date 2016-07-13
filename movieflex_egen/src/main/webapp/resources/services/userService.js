(function(){
var userService = function($http, $q, $rootScope,$window, $cookieStore) {
	return ({
		addUser : addUser,
		setCredentials : setCredentials,
		clearCredentials : clearCredentials,
		login : login
	});
	
	

	function addUser(user) {
		return $http.post("http://localhost:8080/movieflex/api/users", user)
				.then(handleSuccess, handleError)
	}

	function login(username, password, role, callback) {
		var authdata = {
			"email" : username,
			"password" : password,
			"role" : role
		}
		return $http.post(
				"http://localhost:8080/movieflex/api/login",
				authdata).then(handleSuccess, handleError)
	}

	function setCredentials(username, password, role) {
		$rootScope.globals = {
			currentUser : {
				username : username,
				role: role
			}
		};
		
		$window.sessionStorage.setItem( 'loggedIn', "true" );
		$cookieStore.put('globals', $rootScope.globals);
		//$cookieStore.get('JSESSIONID');
	}

	function clearCredentials() {
		$rootScope.globals = {};
		$cookieStore.remove('globals');
		$window.sessionStorage.setItem( 'loggedIn', "false" );
		return $http.get("http://localhost:8080/movieflex/api/logout")
				.then(handleSuccess, handleError)
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
angular.module('movieFlex').service('userService',userService);
}());