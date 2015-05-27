(function (){
	
	var app = angular.module("tmdbViewer", ["ngRoute"]);
	
	app.config(function($routeProvider){
		console.log($routeProvider);
		
		$routeProvider
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
			.otherwise({redirectTo:"/search"});
	});
	
}());