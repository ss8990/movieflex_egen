(function(){
	
	 var homeController = function($scope, $location,userService) {
		userService.clearCredentials();
		$scope.userrole = "";
		$scope.login = function() {
			userService.login($scope.credentials.username, $scope.credentials.password, $scope.credentials.role).then(function(data) {
				userService.setCredentials($scope.credentials.username, $scope.credentials.password, $scope.credentials.role);
				$location.path('/');
			}, function() {
				$scope.error = "Username or Password do not match";
			});
		};
	 };
		angular.module('movieFlex').controller('homeController',homeController);
		}());