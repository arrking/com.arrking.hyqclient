'use strict';
angular.module('Hyqclient.controllers', [])

.controller('DashCtrl', function($scope) {
})

.controller('ContactsCtrl', function($scope, Friends) {
  $scope.friends = Friends.all();
})

.controller('FriendDetailCtrl', function($scope, $stateParams, Friends) {
  $scope.friend = Friends.get($stateParams.friendId);
})

.controller('JobsCtrl', function($scope) {
})

.controller('SettingsCtrl', function($scope) {
});