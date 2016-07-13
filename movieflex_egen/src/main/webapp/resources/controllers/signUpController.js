/*(function(){
var signUpController = function($scope,$location,$window, userService){
	var data=$scope.formModel;
	if($scope.formModel.password === $scope.cpassword){
	signUpService.createUser(data);
	}else{
		$scope.errorMessage = "Passwords do not match";
	}
	$scope.formModel={};
	$scope.submit = function(){
		
	userService.addUser($scope.formModel);
	$location.path("/login/");
	$window.alert("User has been registered!");
	}
};
angular.module('movieFlex').controller('signUpController',['$scope','userService',signUpController]);
}());*/

angular.module('movieFlex').controller('signUpController', ['$scope', '$location','$window','userService', function ($scope, $location, $window,userService) {

  $scope.submit = function() {
	  if($scope.formModel.password === $scope.cpassword){
		  userService.addUser($scope.formModel).then(handleSuccess,handleError);
	  }else{
				$scope.errorMessage = "Passwords do not match";
			}
	  
	  function handleError(response) {
			$window.alert("User already exists");
		}

		function handleSuccess(response) {
			console.log(response);
	    	$location.path("/login/");
	    	$window.alert("User has been registered!");
		}
    
  }

}]);