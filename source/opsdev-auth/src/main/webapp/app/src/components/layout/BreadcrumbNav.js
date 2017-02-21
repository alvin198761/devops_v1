import React, {Component, PropTypes} from 'react';
import {connect} from 'dva';
import {Link} from 'dva/router';
import {Breadcrumb, Icon} from 'antd';

class BreadcrumbNav extends Component {

  constructor(props) {
    super(props);
  }

  render() {
    return (
      <div className="ant-layout-breadcrumb">
        <Breadcrumb>
          {
            this.props.routes.map(item => {
                return (<Breadcrumb.Item key={item.path}> {item.title}</Breadcrumb.Item>);
            })
          }
        </Breadcrumb>
      </div>
    );
  }
}


BreadcrumbNav.propTypes = {};

function mapStateToProps({main}) {
  return {main};
}

export default connect(mapStateToProps)(BreadcrumbNav);
