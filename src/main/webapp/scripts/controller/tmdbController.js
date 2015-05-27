(function (){
	
	var app = angular.module("tmdbViewer");
	
	var TmdbController = function($scope, $http, $log) {
		
		var onMovieComplete = function(response){
			$scope.movies = response.data; 
		} 
		
		var onError = function(reason){
			$scope.error = "Something went terribly wrong!"; 
		} 

		$scope.search = function(movieTitle, currentPage) {
			console.log('currentpage: ' + currentPage);
			console.log('movieTitle: ' + movieTitle);
			$http.get("http://localhost:8080/mytmdb/webapi/search/tmdbmovies?page=" + currentPage + "&title=" + movieTitle)
				.then(onMovieComplete, onError);
		}


		var onMovieAdded = function(response){
		} 
		
		$scope.add = function(movieId) {
			$http.get("http://localhost:8080/mytmdb/webapi/movies/add/" + movieId)
				.then(onMovieAdded, onError);
		}
	
	}
	
	app.controller("TmdbController", ["$scope", "$http", "$log", TmdbController]);
	
}());
