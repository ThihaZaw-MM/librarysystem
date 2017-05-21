angular
.module('app')
.config(['$stateProvider', '$urlRouterProvider', '$ocLazyLoadProvider', '$breadcrumbProvider', function($stateProvider, $urlRouterProvider, $ocLazyLoadProvider, $breadcrumbProvider) {
  $stateProvider

  .state('app.components', {
    url: "/components",
    abstract: true,
    template: '<ui-view></ui-view>',
    ncyBreadcrumb: {
      label: 'Actions'
    }
  })
  .state('app.components.publisher', {
    url: '/publishers',
    templateUrl: 'views/components/publisher.html',
    controller:'PublisherController',
    controllerAs:'pubCtrl',
    ncyBreadcrumb: {
      label: 'Publisher'
    },
    resolve: {
      loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
        // you can lazy load controllers
        return $ocLazyLoad.load({
          files: ['js/controllers/publisher.js']
        });
      }]
    }
  })
  .state('app.components.newpublisher', {
    url: '/publishers',
    templateUrl: 'views/components/newpublisher.html',
    controller:'PublisherController',
    controllerAs:'pubCtrl',
    ncyBreadcrumb: {
      label: 'New Publisher'
    },
    resolve: {
      loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
        // you can lazy load controllers
        return $ocLazyLoad.load({
          files: ['js/controllers/publisher.js']
        });
      }]
    }
  })
  .state('app.components.editpublisher', {
    url: '/publishers',
    templateUrl: 'views/components/newpublisher.html',
    controller:'PublisherController',
    controllerAs:'pubCtrl',
    params: { publisher : null },
    ncyBreadcrumb: {
      label: 'Edit Publisher'
    },
    resolve: {
      loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
        // you can lazy load controllers
        return $ocLazyLoad.load({
          files: ['js/controllers/publisher.js']
        });
      }]
    }
  })
  .state('app.components.author', {
    url: '/authors',
    templateUrl: 'views/components/authors.html',
    controller:'AuthorController',
    controllerAs:'authorCtrl',
    ncyBreadcrumb: {
      label: 'Authors'
    },
    resolve: {
      loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
        // you can lazy load controllers
        return $ocLazyLoad.load({
          files: ['js/controllers/author.js']
        });
      }]
    }
  })
  .state('app.components.newauthor', {
    url: '/authors',
    templateUrl: 'views/components/newauthor.html',
    controller:'AuthorController',
    controllerAs:'authorCtrl',
    params: {patientId: 0},
    ncyBreadcrumb: {
      label: 'Author'
    },
    resolve: {
      loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
        // you can lazy load controllers
        return $ocLazyLoad.load({
          files: ['js/controllers/author.js']
        });
      }]
    }
  })
  .state('app.components.editauthor',{
    url: '/editauthor',
    templateUrl: 'views/components/newauthor.html',
    controller:'AuthorController',
    controllerAs:'authorCtrl',
    params: { author : null },
    ncyBreadcrumb: {
      label: 'Edit Authort'
    },
    resolve: {
      loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
        // you can lazy load controllers
        return $ocLazyLoad.load({
          files: ['js/controllers/author.js']
        });
      }]
    }
  })
  .state('app.components.booktype',{
    url: '/booktypes',
    templateUrl: 'views/components/booktypes.html',
    controller: 'BookTypeController',
    controllerAs: 'bookTypeCtrl',
    ncyBreadcrumb: {
      label: 'Book Types'
    },
    resolve: {
      loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
        // you can lazy load controllers
        return $ocLazyLoad.load({
          files: ['js/controllers/booktype.js']
        });
      }]
    }
  })
  .state('app.components.newbooktype',{
    url: '/booktypes',
    templateUrl: 'views/components/newbooktype.html',
    controller: 'BookTypeController',
    controllerAs: 'bookTypeCtrl',
    ncyBreadcrumb: {
      label: 'New Book Type'
    },
    resolve: {
      loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
        // you can lazy load controllers
        return $ocLazyLoad.load({
          files: ['js/controllers/booktype.js']
        });
      }]
    }
  })
  .state('app.components.editbooktype', {
    url: '/booktypes',
    templateUrl: 'views/components/newbooktype.html',
    controller:'BookTypeController',
    controllerAs:'bookTypeCtrl',
    params: { booktype : null },
    ncyBreadcrumb: {
      label: 'Edit Township'
    },
    resolve: {
      loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
        // you can lazy load controllers
        return $ocLazyLoad.load({
          files: ['js/controllers/booktype.js']
        });
      }]
    }
  })
  .state('app.components.language',{
    url: '/languages',
    templateUrl: 'views/components/languages.html',
    controller: 'LanguageController',
    controllerAs: 'lngCtrl',
    ncyBreadcrumb: {
      label: 'Languages'
    },
    resolve: {
      loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
        // you can lazy load controllers
        return $ocLazyLoad.load({
          files: ['js/controllers/language.js']
        });
      }]
    }
  })
  .state('app.components.newlanguage',{
    url: '/languages',
    templateUrl: 'views/components/newlanguage.html',
    controller: 'LanguageController',
    controllerAs: 'lngCtrl',
    ncyBreadcrumb: {
      label: 'Languages'
    },
    resolve: {
      loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
        // you can lazy load controllers
        return $ocLazyLoad.load({
          files: ['js/controllers/language.js']
        });
      }]
    }
  })
  .state('app.components.editlanguage', {
    url: '/languages',
    templateUrl: 'views/components/newlanguage.html',
    controller: 'LanguageController',
    controllerAs: 'lngCtrl',
    params: { language: null },
    ncyBreadcrumb: {
      label: 'Edit Project'
    },
    resolve: {
      loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
        // you can lazy load controllers
        return $ocLazyLoad.load({
          files: ['js/controllers/language.js']
        });
      }]
    }
  })
  .state('app.components.location',{
    url: '/locations',
    templateUrl: 'views/components/locations.html',
    controller: 'LocationController',
    controllerAs: 'locCtrl',
    ncyBreadcrumb: {
      label: 'Book Location'
    },
    resolve: {
      loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
        // you can lazy load controllers
        return $ocLazyLoad.load({
          files: ['js/controllers/location.js']
        });
      }]
    }
  })
  .state('app.components.newlocation',{
    url: '/locations',
    templateUrl: 'views/components/newlocation.html',
    controller: 'LocationController',
    controllerAs: 'locCtrl',
    ncyBreadcrumb: {
      label: 'Book Location'
    },
    resolve: {
      loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
        // you can lazy load controllers
        return $ocLazyLoad.load({
          files: ['js/controllers/location.js']
        });
      }]
    }
  })
  .state('app.components.editlocation',{
    url: '/locations',
    templateUrl: 'views/components/newlocation.html',
    controller: 'LocationController',
    controllerAs: 'locCtrl',
    params: { location : null },
    ncyBreadcrumb: {
      label: 'Book Location'
    },
    resolve: {
      loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
        // you can lazy load controllers
        return $ocLazyLoad.load({
          files: ['js/controllers/location.js']
        });
      }]
    }
  })
  .state('app.components.books',{
    url: '/books',
    templateUrl: 'views/components/booklist.html',
    controller: 'BookController',
    controllerAs: 'bookCtrl',
    ncyBreadcrumb: {
      label: 'Books'
    },
    resolve: {
      loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
        // you can lazy load controllers
        return $ocLazyLoad.load({
          files: ['js/controllers/book.js']
        });
      }]
    }
  })
  .state('app.components.newbook',{
    url: '/books',
    templateUrl: 'views/components/newbook.html',
    controller: 'BookController',
    controllerAs: 'bookCtrl',
    ncyBreadcrumb: {
      label: 'Books'
    },
    resolve: {
      loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
        // you can lazy load controllers
        return $ocLazyLoad.load({
          files: ['js/controllers/book.js']
        });
      }]
    }
  })
  .state('app.components.editbook',{
    url: '/books',
    templateUrl: 'views/components/newbook.html',
    controller: 'BookController',
    controllerAs: 'bookCtrl',
    params: { book : null },
    ncyBreadcrumb: {
      label: 'Books'
    },
    resolve: {
      loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
        // you can lazy load controllers
        return $ocLazyLoad.load({
          files: ['js/controllers/book.js']
        });
      }]
    }
  })
}]);
