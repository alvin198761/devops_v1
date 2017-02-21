import React, {Component, PropTypes} from 'react';
import {connect} from 'dva';
import {Link} from 'dva/router';
import './IndexPage.css';
import { Row} from 'antd';
import Aside from '../components/layout/Aside'

class SettingPage extends Component {

  constructor(props){
    super(props);
  }

  componentWillMount(){
    console.log("setting mount")
  }

  render(){
    return (
      <div >
        <Aside></Aside>
        <div className="ant-layout-content">
          <div style={{minHeight:'500px'}}>
            <div style={{clear: 'both'}}>
              {this.props.children}
            </div>
          </div>
        </div>
      </div>
    );
  }
}

SettingPage.protoTypes ={}

export default SettingPage;
