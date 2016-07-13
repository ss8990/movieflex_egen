(function(){
	var editcontroller = function($scope,$routeParams,$location,movieService){
		
		$scope.newmovie={};
		loadRemoteData();
		
		function loadRemoteData(){
			movieService.getMovie($routeParams.movieId).then(function(movie){
				$scope.newmovie=movie;
				$scope.editform.title=movie.title;
				$scope.editform.year=movie.year;
				console.log($scope.newmovie.title);
			});
		}
		
		$scope.editMovie = function(){
			movieService.updateMovie($routeParams.movieId,$scope.newmovie).then(function(movie){
				$scope.movie=movie;
				$location.path("/movies");
				console.log(movie);
			});
		}
		
	};
	angular.module('movieFlex').controller('editController',editcontroller);
}(window.angular));