angular
.module('app')
.controller('LocationController',
	['$scope', '$stateParams', '$http', '$location','urls', 
	function($scope, $stateParams, $http, $location, urls) {
		var self = this;
    	self.location = {};
    	self.locations = [];
    	self.submit = submit;
		self.deleteLocation = deleteLocation;
    	self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

		console.log("Fetching locations");

		if($stateParams.location != null){
            console.log($stateParams.location);
            self.location = $stateParams.location;
        }

		$http.get(urls.USER_SERVICE_API + "locations")
			.then(
				function (response) {
					self.locations = response.data;
				},
				function (errResponse) {
		            console.error('Error while loading locations');
		        }
			);

		function submit() {
			if (self.location.id === undefined || self.location.id === null) {
                console.log('Saving New Location', self.location);
                createLocation(self.location);
            } else {
                console.log('location updated with id ', self.location.id);
				updateLocation(self.location);
            }
		}

		function updateLocation(location) {
			$http.put(urls.USER_SERVICE_API + "locations/" + location.id, location)
				.then(
					function (response) {
						console.log('Save success for new location');
			        	$location.path('/locations');
					}, 
					function (errResponse) {
						console.error('Error while saving new location');
			            console.error(errResponse);
					}
				);
		}

		function createLocation(location) {
            console.log('About to create location');
			location.id = "2d856332-d21f-4732-9787-1c2ddf21e0a0";
			$http.post(urls.USER_SERVICE_API + "locations", location)
			    .then(
			        function (response) {
			        	console.log('Save success for new location');
			        	//console.log($location)
			        	$location.path('/locations');
			        },
			        function (errResponse) {
			            console.error('Error while saving new location');
			            console.error(errResponse);
			        }
			  );
        }

		function deleteLocation(id) {
			console.log('Deleting location' + id);
			$http.delete(urls.USER_SERVICE_API + "locations/" + id)
				.then(
					function (response) {
						console.log('Delete success for location');
			        	var index = -1;		
						var locationArr = eval( self.locations );
						for( var i = 0; i < locationArr.length; i++ ) {
							if( locationArr[i].id === id ) {
								index = i;
								break;
							}
						}
						
						if(index >= 0) {
							self.locations.splice( index, 1 );
						}
					}, 
					function (errResponse) {
						console.error('Error while deleting location');
			            console.error(errResponse);
					}
				);
		}
	}
]);