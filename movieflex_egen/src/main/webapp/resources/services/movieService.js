(function(){
var movieService = function($http, $q) {
	return ({
		getMovies : getMovies,
		getMovie : getMovie,
		createMovie : createMovie,
		updateMovie : updateMovie,
		submitRating : submitRating,
		deleteMovie : deleteMovie
	});

	function createMovie(movie) {
		return $http.post("http://localhost:8080/movieflex/api/movies",
				movie).then(handleSuccess, handleError)
	}

	function getMovies() {
		return $http.get("http://localhost:8080/movieflex/api/movies").then(handleSuccess, handleError)
	}

	function getMovie(movieId) {
		return $http.get(
				"http://localhost:8080/movieflex/api/movies/" + movieId)
				.then(handleSuccess, handleError)
	}

	function updateMovie(movieId,movie) {
		return $http.put("http://localhost:8080/movieflex/api/movies/"+
				movieId,movie).then(handleSuccess, handleError)
	}
	
	function submitRating(movieId, choice){
		return $http.post("http://localhost:8080/movieflex/api/movies/"+
				movieId+"/reviews",choice).then(handleSuccess, handleError)

	}

	function deleteMovie(movieId) {
		return $http.delete(
				"http://localhost:8080/movieflex/api/movies/" + movieId)
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
angular.module('movieFlex').service('movieService',movieService);
}());