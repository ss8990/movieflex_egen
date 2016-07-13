(function(){
    var app=angular.module('movieFlex',['ngRoute','ngCookies']);
    app.config(function($routeProvider){
        $routeProvider
        .when('/movieflex/',{
            templateUrl:'resources/partials/home.html'
        })
        .when('/movies/',{
            controller:'moviesController',
            templateUrl:'resources/partials/movies.html'
        })
        .when('/topratedmovies/',{
            controller:'moviesController',
            templateUrl:'resources/partials/topratedmovies.html'
        })
        .when('/topratedseries/',{
            controller:'moviesController',
            templateUrl:'resources/partials/topratedseries.html'
        })
        .when('/createmovie/',{
            controller:'moviesController',
            templateUrl:'resources/partials/createmovie.html'
        })
        .when('/editmovie/:movieId',{
            controller:'editController',
            templateUrl:'resources/partials/editmovie.html'
        })
        .when('/deletemovie/:movieId',{
            controller:'deleteController',
            templateUrl:'resources/partials/movies.html'
        })
        .when('/movies/:movieId',{
            controller:'movieController',
            templateUrl:'resources/partials/movie.html'
        })
        .when('/signup/',{
            controller:'signUpController',
            templateUrl:'resources/partials/signup.html'
        })
        .when('/login/',{
            controller:'homeController',
            templateUrl:'resources/partials/login.html'
        })
        .otherwise({redirectTo:'/movieflex/'});
    })
    .run(
			[
					'$rootScope',
					'$location',
					'$cookieStore',
					'$http',
					function($rootScope, $location, $cookieStore, $http) {
						$rootScope.globals = $cookieStore.get('globals')
								|| {};
						if ($rootScope.globals.currentUser) {
							$http.defaults.headers.common['Authorization'] = 'Basic '
									+ $rootScope.globals.currentUser.authdata;
						}

						$rootScope
								.$on(
										'$locationChangeStart',
										function(event, next, current) {
											if ($location.path() !== '/signup'
													&& $location.path() !== '/logout'
													&& $location.path() !== '/movies'
													&& $location.path() !=='/login'
													&& $location.path() == '/login'
													&& !$rootScope.globals.currentUser) {
												$location.path('/movieflex');
											}
										});
										
						
					} ]);
}());