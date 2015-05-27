(function (){
	
	var app = angular.module("tmdbViewer");
	
	var MyMovieListController = function($scope, $http, $log, $location) {
		
		var onMovieComplete = function(response){
			$scope.mymovies = response.data;
		}; 
		
		var onError = function(reason){
			$scope.error = "No movies in your collection, or something went wrong wen getting the list: " ; 
		}; 

		var search = function() {
			$http.get("http://localhost:8080/mytmdb/webapi/search/movies")
				.then(onMovieComplete, onError);
		};
		
		var onMovieDelete = function(response){
			search();
		}; 

		$scope.deleteMovie = function(movieId){
			$http.delete("http://localhost:8080/mytmdb/webapi/movies/" + movieId)
				.then(onMovieDelete, onError);
		}
		
		var onMovieUpdate = function(response){
			search();
		}; 

		$scope.toggleSeen = function(movieId, movieSeen){
			$http.put("http://localhost:8080/mytmdb/webapi/movies/" + movieId + "/seen")
				.then(onMovieUpdate, onError);
		};
		
		$scope.showDetails = function(movieid){
			$location.path("/myMovieDetails/" + movieid);
		};

		search();
	}
	
	app.controller("MyMovieListController", ["$scope", "$http", "$log", "$location",  MyMovieListController]);
	
}());
