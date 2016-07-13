(function(){
var moviesController =  function($scope, movieService) {
	$scope.movies = [];
	$scope.topmovies = [];
	$scope.topseries = [];
	$scope.movieform = {};

	loadRemoteData();

	function loadRemoteData() {
		movieService.getMovies().then(function(movies) {
			applyMovies(movies);
		});
	}

	function applyMovies(movies) {
		$scope.movies = movies;
		for(var i=0;i<$scope.movies.length;i++){
			if(movies[i].type == "movie"){
				$scope.topmovies.push(movies[i]);
			}else if(movies[i].type == "series"){
				$scope.topseries.push(movies[i]);
			}else{
				continue;
			}
		}
		console.log(movies[0]);
	}
	
	$scope.submitMovie = function(){
		movieService.createMovie($scope.movieform).then(function(movie){
			$scope.movies.push(movie);
		})
	}
	
	

};
angular.module('movieFlex').controller('moviesController',moviesController);
}());