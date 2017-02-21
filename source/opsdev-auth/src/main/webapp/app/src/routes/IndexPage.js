import React, {Component, PropTypes} from 'react';
import {connect} from 'dva';
import {Link} from 'dva/router';
import './IndexPage.css';
import {Menu, Breadcrumb, Icon, BackTop} from 'antd';
import BreadcrumbNav from '../components/layout/BreadcrumbNav'
import Header from '../components/layout/Header'

class IndexPage extends Component {

  constructor(props) {
    super(props);
  }

  componentWillMount() {
    // this.props.dispatch({type: 'main/checkLogin'});
  }

  render() {
    return (
      <div>
        <div className="ant-layout-topaside">
          <Header></Header>
          <div className="ant-layout-wrapper">
            <BreadcrumbNav routes={this.props.routes}></BreadcrumbNav>
            <div className="ant-layout-container">
              {this.props.children}
            </div>
            <div className="ant-layout-footer">
              alvin198761@163.com 个人兴趣爱好
            </div>
          </div>
        </div>
        <BackTop />
      </div>
    )
  }
}

IndexPage.propTypes = {};


function mapStateToProps({main}) {
  return {main};
}
export default connect(mapStateToProps)(IndexPage);
