(function (){
	
	var app = angular.module("tmdbViewer");
	
	var TmdbController = function($scope, $http, $log, $rootScope) {
		
		var onMovieComplete = function(response){
			$scope.movies = response.data; 
		} 
		
		var onError = function(reason){
			$scope.error = "There are no results or the service was down!"; 
		} 

		$scope.search = function(movieTitle, currentPage) {
			$http.get("http://84.196.249.71:8080/mytmdb/webapi/search/tmdbmovies?page=" + currentPage + "&title=" + movieTitle)
				.then(onMovieComplete, onError);
		}


		var onMovieAdded = function(response){
		} 
		
		$scope.add = function(movieId) {
			$http.get("http://84.196.249.71:8080/mytmdb/webapi/movies/add/" + movieId)
				.then(onMovieAdded, onError);
		}
		
		var setMenu = function(){
        	$rootScope.menuOption = 'search';
		}
		
		setMenu();
	
	}
	
	app.controller("TmdbController", ["$scope", "$http", "$log", "$rootScope", TmdbController]);
	
}());
