(function(){
	var movieController = function($scope,$routeParams,$window,movieService){
		
		$scope.movie={};
		loadRemoteData();
		$scope.userrating=0.0;
		
		function loadRemoteData(){
			movieService.getMovie($routeParams.movieId).then(function(movie){
				$scope.movie=movie;
				var total=0.0;
				for(var i=0;i<movie.ratings.length;i++){
					total+=movie.ratings[i].rating;
				}
				if(movie.ratings.length>0){
				$scope.userrating=total/movie.ratings.length;
				}
				console.log(movie.ratings);
			});
		}
		
		$scope.submitRating = function(){
			movieService.submitRating($routeParams.movieId,$scope.userchoice).then(function(movie){
				//$scope.userrating=($scope.userrating+$scope.userchoice.rating)/movie.ratings.length;
				$window.location.reload();
				$scope.userchoice.review="";
				$scope.userchoice.rating="";
				$scope.movie=movie;
				
				console.log(movie);
			});
		}
		
		
	};
	angular.module('movieFlex').controller('movieController',movieController);
}());