(function(){
var deleteController =  function($scope,$routeParams,$location, movieService) {
	
	movieService.deleteMovie($routeParams.movieId).then(function(){
		$location.path("/");
		});
	};
	angular.module('movieFlex').controller('deleteController',deleteController);
}());