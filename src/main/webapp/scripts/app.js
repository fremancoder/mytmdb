(function (){
	
	// declare modules
	angular.module('Authentication', []);
	angular.module('Home', []);
	
	var app = angular.module("tmdbViewer", ["ngRoute", "ngCookies", "Authentication", "Home"]);
	
	app.config(function($routeProvider){
		console.log($routeProvider);
		
		$routeProvider
			.when('/login', 
					{
						controller: 'LoginController',
						templateUrl: 'views/login.html'
					})		
			.when("/search", 
					{
						templateUrl: "views/search.html",
						controller: "TmdbController"
					})
			.when("/myMovies", 
					{
						templateUrl: "views/myMovies.html",
						controller: "MyMovieListController"
					})
			.when("/myMovieDetails/:movieid", 
					{
						templateUrl: "views/myMovieDetail.html",
						controller: "MyMovieDetailController"
					})
			.otherwise({redirectTo:"/login"});
	}).run(['$rootScope', '$location', '$cookieStore', '$http', function ($rootScope, $location, $cookieStore, $http) {
        
		$rootScope.globals = $cookieStore.get('globals') || {};
        
		if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
        }
  
        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            if ($location.path() !== '/login' && !$rootScope.globals.currentUser) {
                $location.path('/login');
            }
        });
        
    }]);
	
}());