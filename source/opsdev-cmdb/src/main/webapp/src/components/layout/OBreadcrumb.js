import React from 'react';
import {Breadcrumb,Icon} from 'antd';
import {Link} from 'dva/router';

const OBreadcrumb = (props) => {
  const router = props.routes;
  let title = "设备管理";
  if(router != null || router.length >= 2){
    title = router[1].title;
  }

  return (
    <Breadcrumb>
      <Breadcrumb.Item><Link to="/"><Icon type="home" /></Link></Breadcrumb.Item>
      <Breadcrumb.Item>{title}</Breadcrumb.Item>
    </Breadcrumb>
  );
};

OBreadcrumb.propTypes = {};

export default OBreadcrumb;
