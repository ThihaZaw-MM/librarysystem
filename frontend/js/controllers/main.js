//main.js
angular
.module('app')
.controller('memberCountCtrl', memberCountCtrl)
.controller('bookStatusCtrl', bookStatusCtrl)
.controller('authorStatusCtrl', authorStatusCtrl)
.controller('publisherStatusCtrl', publisherStatusCtrl)
.controller('newArrivalCtrl', newArrivalCtrl)

function convertHex(hex,opacity){
  hex = hex.replace('#','');
  r = parseInt(hex.substring(0,2), 16);
  g = parseInt(hex.substring(2,4), 16);
  b = parseInt(hex.substring(4,6), 16);

  result = 'rgba('+r+','+g+','+b+','+opacity/100+')';
  return result;
}

memberCountCtrl.$inject = ['$scope'];
function memberCountCtrl($scope) {
    $scope.labels = ['January','February','March','April','May','June','July'];
    $scope.data = [
        [65, 59, 84, 84, 51, 55, 40]
    ];
    $scope.colors = [{
        backgroundColor: brandPrimary,
        borderColor: 'rgba(255,255,255,.55)',
    }];
    $scope.options = {
        maintainAspectRatio: false,
        scales: {
        xAxes: [{
            gridLines: {
            color: 'transparent',
            zeroLineColor: 'transparent'
            },
            ticks: {
            fontSize: 2,
            fontColor: 'transparent',
            }

        }],
        yAxes: [{
            display: false,
            ticks: {
            display: false,
            min: Math.min.apply(Math, $scope.data[0]) - 5,
            max: Math.max.apply(Math, $scope.data[0]) + 5,
            }
        }],
        },
        elements: {
        line: {
            borderWidth: 1
        },
        point: {
            radius: 4,
            hitRadius: 10,
            hoverRadius: 4,
        },
        },
    }
}

bookStatusCtrl.$inject = ['$scope'];
function bookStatusCtrl($scope) {

  $scope.labels = ['January','February','March','April','May','June','July'];
  $scope.data = [
    [1, 18, 9, 17, 34, 22, 11]
  ];
  $scope.colors = [{
    backgroundColor: brandInfo,
    borderColor: 'rgba(255,255,255,.55)',
  }];
  $scope.options = {
    maintainAspectRatio: false,
    scales: {
      xAxes: [{
        gridLines: {
          color: 'transparent',
          zeroLineColor: 'transparent'
        },
        ticks: {
          fontSize: 2,
          fontColor: 'transparent',
        }

      }],
      yAxes: [{
        display: false,
        ticks: {
          display: false,
          min: Math.min.apply(Math, $scope.data[0]) - 5,
          max: Math.max.apply(Math, $scope.data[0]) + 5
        }
      }],
    },
    elements: {
      line: {
        tension: 0.00001,
        borderWidth: 1
      },
      point: {
        radius: 4,
        hitRadius: 10,
        hoverRadius: 4,
      },

    },
  }
}

authorStatusCtrl.$inject = ['$scope'];
function authorStatusCtrl($scope) {

  $scope.labels = ['January','February','March','April','May','June','July'];
  $scope.data = [
    [78, 81, 80, 45, 34, 12, 40]
  ];
  $scope.data4 = [
    [35, 23, 56, 22, 97, 23, 64]
  ];
  $scope.colors = [{
    backgroundColor: 'rgba(255,255,255,.2)',
    borderColor: 'rgba(255,255,255,.55)',
  }];
  $scope.options = {
    maintainAspectRatio: false,
    scales: {
      xAxes: [{
        display: false
      }],
      yAxes: [{
        display: false
      }]
    },
    elements: {
      line: {
        borderWidth: 2
      },
      point: {
        radius: 0,
        hitRadius: 10,
        hoverRadius: 4,
      },
    },
  }
}

function random(min,max) {
  return Math.floor(Math.random()*(max-min+1)+min);
}

publisherStatusCtrl.$inject = ['$scope'];
function publisherStatusCtrl($scope) {

  var elements = 16;
  var labels = [];
  var data = [];
  //
  for (var i = 2000; i <= 2000 + elements; i++) {
    labels.push(i);
    data.push(random(40,100));
  }

  $scope.labels = labels;

  $scope.data = [data];

  $scope.colors = [{
    backgroundColor: 'rgba(255,255,255,.3)',
    borderWidth: 0
  }];
  $scope.options = {
    maintainAspectRatio: false,
    scales: {
      xAxes: [{
        display: false,
        barPercentage: 0.6,
      }],
      yAxes: [{
        display: false
      }]
    },
  }
}

newArrivalCtrl.$inject = ['$scope', '$http', 'urls'];
function newArrivalCtrl($scope, $http, urls) {

    //$scope.data = [];
    $http.get(urls.USER_SERVICE_API + "books")
        .then(
            function (response) {
                console.log('Fetched successfully all books');
                $scope.data = response.data;
            },
            function (errResponse) {
                console.error('Error while loading books');
            }
        );
}