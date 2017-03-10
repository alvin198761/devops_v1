import React, {Component, PropTypes} from 'react';
import {connect} from 'dva';
import {Menu, Breadcrumb, Icon} from 'antd';
import  './IndexPage.css';

import OHeader from '../components/layout/OHeader';
import SiteBar from '../components/layout/SiteBar';
import OBreadcrumb from '../components/layout/OBreadcrumb';

function IndexPage(props) {
 // console.log(props)
  return (
    <div className="ant-layout-topaside">
      <OHeader></OHeader>
      <div className="ant-layout-wrapper">
        <div className="ant-layout-breadcrumb">
          <OBreadcrumb routes={props.routes}></OBreadcrumb>
        </div>
        <div className="ant-layout-container">
          <SiteBar routes={props.routes}></SiteBar>
          <div className="ant-layout-content">
            <div style={{height: 390}}>
              <div style={{clear: 'both'}}>{ props.children}</div>
            </div>
          </div>
        </div>
        <div className="ant-layout-footer">
          alvin198761@163.com 个人爱好
        </div>
      </div>
    </div>
  );
}

IndexPage.propTypes = {};

export default connect()(IndexPage);
