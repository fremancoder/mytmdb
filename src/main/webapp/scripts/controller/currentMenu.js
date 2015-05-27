(function(){
	
	var app = angular.module("tmdbViewer");
	
	var MyMenuController = function($location, $scope) {
		
		$scope.switch = function(type){
			if(type == 'search') {
				$scope.currentMenuMyMovies = false;
			} else {
				$scope.currentMenuMyMovies = true;
			}
		}
		
	}	
	
	app.controller("MyMenuController", ["$location", "$scope", MyMenuController]);
	
}());