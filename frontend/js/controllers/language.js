angular
.module('app')
.controller('LanguageController',
	['$scope', '$stateParams', '$http', '$location','urls', 
	function($scope, $stateParams, $http, $location, urls) {
		var self = this;
    	self.language = {};
    	self.languages = [];
    	self.submit = submit;
		self.deleteLanguage = deleteLanguage;
    	self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

		console.log("Fetching Languages");

		if($stateParams.language != null){
            console.log($stateParams.language);
            self.language = $stateParams.language;
        }

		$http.get(urls.USER_SERVICE_API + "languages")
			.then(
				function (response) {
					self.languages = response.data;
				},
				function (errResponse) {
		            console.error('Error while loading languages');
		        }
			);

		function submit() {
			if (self.language.id === undefined || self.language.id === null) {
                console.log('Saving New Location', self.language);
                createLanguage(self.language);
            } else {
                console.log('language updated with id ', self.language.id);
				updateLanguage(self.language);
            }
		}

		function updateLanguage(language) {
			$http.put(urls.USER_SERVICE_API + "languages/" + language.id, language)
				.then(
					function (response) {
						console.log('Save success for new language');
			        	$location.path('/languages');
					}, 
					function (errResponse) {
						console.error('Error while saving new language');
			            console.error(errResponse);
					}
				);
		}

		function createLanguage(language) {
            console.log('About to create language');
			language.id = "2d856332-d21f-4732-9787-1c2ddf21e0a0";
			$http.post(urls.USER_SERVICE_API + "languages", language)
			    .then(
			        function (response) {
			        	console.log('Save success for new language');
			        	//console.log($location)
			        	$location.path('/languages');
			        },
			        function (errResponse) {
			            console.error('Error while saving new language');
			            console.error(errResponse);
			        }
			  );
        }

		function deleteLanguage(id) {
			console.log('Deleting language' + id);
			$http.delete(urls.USER_SERVICE_API + "languages/" + id)
				.then(
					function (response) {
						console.log('Delete success for language');
			        	var index = -1;		
						var languageArr = eval( self.languages );
						for( var i = 0; i < languageArr.length; i++ ) {
							if( languageArr[i].id === id ) {
								index = i;
								break;
							}
						}
						
						if(index >= 0) {
							self.languages.splice( index, 1 );
						}
					}, 
					function (errResponse) {
						console.error('Error while deleting language');
			            console.error(errResponse);
					}
				);
		}
	}
]);