/**
 * Created by tangzhichao on 2016/12/22.
 */

'use strict';

const page = [
  {
    name: 'one',
    apps: [
      {title: '资源管理', icon: 'hdd', url: '#1', description: '这是一个神奇的APP,你值得拥有'},
      {title: '资源管理', icon: 'hdd', url: '#2', description: '这是一个神奇的APP,你值得拥有'},
      {title: '资源管理', icon: 'hdd', url: '#3', description: '这是一个神奇的APP,你值得拥有'},
      {title: '资源管理', icon: 'hdd', url: '#4', description: '这是一个神奇的APP,你值得拥有'},
      {title: '资源管理', icon: 'hdd', url: '#5', description: '这是一个神奇的APP,你值得拥有'},
      {title: '资源管理', icon: 'hdd', url: '#6', description: '这是一个神奇的APP,你值得拥有'}
    ]
  },
  {
    name: 'tow',
    apps: [
      {title: '办公管理', icon: 'user', url: '#1', description: '这是一个神奇的APP,你值得拥有'},
      {title: '办公管理', icon: 'user', url: '#2', description: '这是一个神奇的APP,你值得拥有'},
      {title: '办公管理', icon: 'user', url: '#3', description: '这是一个神奇的APP,你值得拥有'},
      {title: '办公管理', icon: 'user', url: '#4', description: '这是一个神奇的APP,你值得拥有'},
      {title: '办公管理', icon: 'user', url: '#5', description: '这是一个神奇的APP,你值得拥有'},
      {title: '办公管理', icon: 'user', url: '#6', description: '这是一个神奇的APP,你值得拥有'}
    ]
  },
  {
    name: 'three',
    apps: [
      {title: '资源管理', icon: 'hdd', url: '#1', description: '这是一个神奇的APP,你值得拥有'},
      {title: '资源管理', icon: 'hdd', url: '#2', description: '这是一个神奇的APP,你值得拥有'},
      {title: '资源管理', icon: 'hdd', url: '#3', description: '这是一个神奇的APP,你值得拥有'},
      {title: '资源管理', icon: 'hdd', url: '#4', description: '这是一个神奇的APP,你值得拥有'},
      {title: '资源管理', icon: 'hdd', url: '#5', description: '这是一个神奇的APP,你值得拥有'},
      {title: '资源管理', icon: 'hdd', url: '#6', description: '这是一个神奇的APP,你值得拥有'}
    ]
  },
  {
    name: 'fore',
    apps: [
      {title: '资源管理', icon: 'hdd', url: '#1', description: '这是一个神奇的APP,你值得拥有'},
      {title: '资源管理', icon: 'hdd', url: '#2', description: '这是一个神奇的APP,你值得拥有'},
      {title: '资源管理', icon: 'hdd', url: '#3', description: '这是一个神奇的APP,你值得拥有'},
      {title: '资源管理', icon: 'hdd', url: '#4', description: '这是一个神奇的APP,你值得拥有'},
      {title: '资源管理', icon: 'hdd', url: '#5', description: '这是一个神奇的APP,你值得拥有'},
      {title: '资源管理', icon: 'hdd', url: '#6', description: '这是一个神奇的APP,你值得拥有'}
    ]
  },
]
const list = {
  "content": [
    {id: 1, title: '资源管理', icon: 'hdd', url: '#1', description: '这是一个神奇的APP,你值得拥有'},
    {id: 2, title: '资源管理', icon: 'hdd', url: '#2', description: '这是一个神奇的APP,你值得拥有'},
    {id: 6, title: '资源管理', icon: 'hdd', url: '#3', description: '这是一个神奇的APP,你值得拥有'},
    {id: 3, title: '资源管理', icon: 'hdd', url: '#4', description: '这是一个神奇的APP,你值得拥有'},
    {id: 4, title: '资源管理', icon: 'hdd', url: '#5', description: '这是一个神奇的APP,你值得拥有'},
    {id: 5, title: '资源管理', icon: 'hdd', url: '#6', description: '这是一个神奇的APP,你值得拥有'}
  ],
  "totalPages": 50,
  "totalElements": 500,
  "last": true,
  "number": 0,
  "size": 10,
  "numberOfElements": 0,
  "sort": null,
  "first": true
}

const icons = ['lock', 'unlock', 'android', 'apple', 'apple-o', 'area-chart', 'pie-chart', 'bar-chart', 'dot-chart', 'bars', 'book', 'calendar', 'cloud', 'cloud-download', 'code', 'code-o', 'copy', 'credit-card', 'delete', 'desktop', 'download', 'edit', 'ellipsis', 'file', 'file-text', 'file-unknown', 'file-pdf', 'file-excel', 'file-jpg', 'file-ppt', 'addfile', 'addfolder', 'folder', 'folder-open', 'github', 'hdd', 'frown', 'frown-o', 'meh', 'meh-o', 'smile', 'smile-o', 'inbox', 'laptop', 'appstore-o', 'appstore', 'line-chart', 'link', 'logout', 'mail', 'menu-fold', 'menu-unfold', 'mobile', 'notification', 'paper-clip', 'picture', 'poweroff', 'reload', 'search', 'setting', 'share-alt', 'shopping-cart', 'tablet', 'tag', 'tag-o', 'tags', 'tags-o', 'to-top', 'upload', 'user', 'video-camera', 'windows', 'windows-o', 'ie', 'chrome', 'home', 'loading', 'loading-3-quarters', 'cloud-upload-o', 'cloud-download-o', 'cloud-upload', 'cloud-o', 'star-o', 'star', 'heart-o', 'heart', 'environment', 'environment-o', 'eye', 'eye-o', 'camera', 'camera-o', 'aliwangwang', 'aliwangwang-o', 'dingding', 'dingding-o', 'save', 'team', 'solution', 'phone', 'filter', 'exception', 'export', 'customer-service', 'qrcode', 'scan', 'like', 'like-o', 'dislike', 'dislike-o', 'message', 'pay-circle', 'pay-circle-o', 'calculator', 'pushpin', 'pushpin-o', 'bulb', 'select', 'switcher', 'rocket']

module.exports = {

  'GET /appstore/fetch': function (req, res) {
    setTimeout(function () {
      res.json(page);
    }, 500);
  },

  'GET /appstore/list': function (req, res) {
    list.number = parseInt(req.query.page);
    setTimeout(function () {
      res.json(list);
    }, 500);
  },
};

