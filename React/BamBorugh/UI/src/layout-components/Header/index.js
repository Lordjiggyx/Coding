import React, { Fragment, Component } from 'react';

import clsx from 'clsx';
import { Link } from 'react-router-dom';

import { connect } from 'react-redux';

import projectLogo from '../../assets/images/react.svg';

class Header extends Component {
  render() {
    let { headerShadow } = this.props;

    return (
      <Fragment>
        <div className="header-nav-wrapper header-nav-wrapper-lg" />
        <div
          className={clsx(
            'app-header bg-second header-nav-wrapper header-nav-wrapper-lg w-100 navbar-light',
            { 'app-header--shadow': headerShadow }
          )}>
          <div className="container-fluid">
            <div className="nav-logo">
              <Link to="/" title="Bamburgh React UI Kit with Reactstrap Free">
                <span className="text-white pb-2">Bamburgh</span>
                <i className="bg-transparent">
                  <img
                    alt="Bamburgh React UI Kit with Reactstrap Free"
                    src={projectLogo}
                  />
                </i>
              </Link>
            </div>
          </div>
        </div>
      </Fragment>
    );
  }
}

const mapStateToProps = state => ({
  headerShadow: state.ThemeOptions.headerShadow
});

export default connect(mapStateToProps)(Header);
