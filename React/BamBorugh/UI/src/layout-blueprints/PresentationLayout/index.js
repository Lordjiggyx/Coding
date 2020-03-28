import React, { Fragment } from 'react';
import clsx from 'clsx';
import PropTypes from 'prop-types';

import { connect } from 'react-redux';

import { Header, Footer } from '../../layout-components';

const PresentationLayout = props => {
  const { children, contentBackground } = props;

  return (
    <Fragment>
      <div className={clsx(contentBackground)}>
        <Header />
        <div className="container-fluid px-5">{children}</div>
        <Footer />
      </div>
    </Fragment>
  );
};

PresentationLayout.propTypes = {
  children: PropTypes.node
};

const mapStateToProps = state => ({
  contentBackground: state.ThemeOptions.contentBackground
});

export default connect(mapStateToProps)(PresentationLayout);
