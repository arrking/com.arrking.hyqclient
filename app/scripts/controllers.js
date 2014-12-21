'use strict';
angular.module('Hyqclient.controllers', [])

.controller('DashCtrl', function($scope) {

	$scope.handleSlideClicked = function(index) {
	};
})

.controller('ContactsCtrl', function($scope) {

	$scope.contacts = [];
	$scope.alphabet = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';

	for (var idx = 0; idx < 5; idx++) {
		$scope.contacts.push({
			'name': {
				'firstname': '锋',
				'lastname': '雷'
			},
			'id': idx,
			'phone': '1380000000',
			'city': '北京市',
			'company': '中华美食家协会'
		});
	}

})

.controller('FriendDetailCtrl', function ($scope, $stateParams, Friends) {
  $scope.friend = Friends.get($stateParams.friendId);
})

.controller('JobsCtrl', function ($scope) {
	$scope.positions = [];

	for(var idx = 0; idx < 20; idx++) {
		$scope.positions.push({
			'id': idx,
			'title': '招聘厨师，五险一金，供吃住',
			'company': '海底捞餐饮文化有限公司',
			'city': '北京',
			'salary': [10000, 15000]
		});
	}
})

.controller('JobsDetailCtrl', function ($scope) {

})

.controller('SettingsCtrl', function ($scope) {
});
