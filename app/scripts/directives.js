'use strict';
angular.module('Hyqclient.directives', [])

.directive('alphaSidebar', function ($templateCache) {
    return {
        restrict: 'E',
        transclude: true,
        template: '<div class="alpha-sidebar">' +
            '<ul>' +
            '<li ng-repeat="letter in alphabet">{{letter}}</li>' +
            '</ul>' +
            '<div ng-if=""></div>' +
            '</div>',
        scope: {
            alphabet: '=alphabet'
        },
        replace: false,
        link: function ($scope, iElement, iAttrs, controller) {
            return true;
        }
    };
});