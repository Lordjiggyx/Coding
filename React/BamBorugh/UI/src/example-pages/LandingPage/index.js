import React, { Fragment } from 'react';

import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import hero8 from '../../assets/images/hero-bg/hero-8.jpg';

import { Button, UncontrolledTooltip, Badge } from 'reactstrap';

import IconsFontawesome from '../../example-components/Icons/IconsFontawesome';
import IconsPe7 from '../../example-components/Icons/IconsPe7';

import Buttons from '../Buttons';
import Dropdowns from '../Dropdowns';
import NavigationMenus from '../NavigationMenus';
import ProgressBars from '../ProgressBars';
import Pagination from '../Pagination';
import Scrollable from '../Scrollable';
import Badges from '../Badges';
import Icons from '../Icons';
import UtilitiesHelpers from '../UtilitiesHelpers';
import Cards3 from '../Cards3';
import ListGroups from '../ListGroups';
import Modals from '../Modals';
import Notifications from '../Notifications';
import Carousels from '../Carousels';
import Popovers from '../Popovers';
import Tooltips from '../Tooltips';
import Tabs from '../Tabs';
import RegularTables1 from '../RegularTables1';
import RegularTables4 from '../RegularTables4';
import FormsLayout from '../FormsLayout';
import FormsControls from '../FormsControls';
import ApexCharts from '../ApexCharts';
import Maps from '../Maps';

const LandingPage = () => {
  return (
    <Fragment>
      <div className="rm-padding-wrapper">
        <div className="hero-wrapper bg-composed-wrapper min-vh-100 bg-premium-dark pt-5">
          <div className="flex-grow-1 w-100 d-flex align-items-center">
            <div
              className="bg-composed-wrapper--image bg-composed-filter-rm opacity-6"
              style={{ backgroundImage: 'url(' + hero8 + ')' }}
            />
            <div className="bg-composed-wrapper--bg bg-vicious-stance opacity-5" />
            <div className="bg-composed-wrapper--content pt-5 pb-2 py-lg-5">
              <div className="container py-5">
                <div className="row">
                  <div className="col-lg-8 px-0 mx-auto d-flex align-items-center">
                    <div className="text-center">
                      <Badge
                        pill
                        color="info"
                        className="px-4 text-uppercase h-auto py-1"
                        id="ProjVersion123">
                        FREE react UI Kit
                      </Badge>
                      <UncontrolledTooltip
                        placement="top"
                        target="ProjVersion123">
                        Version: 1.1.0
                      </UncontrolledTooltip>

                      <div className="px-4 px-sm-0 text-white mt-5">
                        <h1 className="display-2 mb-5 font-weight-bold">
                          Bamburgh React UI Kit with Reactstrap Free
                        </h1>
                        <p className="font-size-xl text-white-50 mb-3">
                          This React Ui Kit will bring you a beautiful and
                          custom Bootstrap style to use in your presentation
                          websites.
                        </p>
                        <p className="text-white font-size-lg">
                          Working on a smaller project and need a simple,
                          beautiful and easy to use Ui Kit? Search no more,
                          you&#39;ve found the perfect one.
                        </p>
                        <div className="divider border-2 border-light my-5 border-light opacity-2 mx-auto rounded-circle w-50"></div>
                        <div>
                          <Button
                            tag="a"
                            size="lg"
                            color="success"
                            className="btn-pill d-block d-sm-inline-block px-5 py-3 ml-0 mt-3 mt-sm-0 ml-sm-3"
                            href="https://uifort.com/template/bamburgh-react-ui-kit-reactstrap-free"
                            target="_blank"
                            title="Download Bamburgh React UI Kit with Reactstrap Free">
                            <span className="btn-wrapper--icon">
                              <FontAwesomeIcon icon={['fas', 'download']} />
                            </span>
                            <span className="btn-wrapper--label">
                              Download now
                            </span>
                          </Button>
                          <Button
                            tag="a"
                            href="https://uifort.com/template/bamburgh-react-ui-kit-reactstrap-pro"
                            target="_blank"
                            size="lg"
                            color="first"
                            className="px-5 py-3 btn-pill d-block d-sm-inline-block ml-0 ml-sm-3 mt-3 mt-sm-0"
                            title="Learn more about Bamburgh React UI Kit Reactstrap PRO version">
                            <span className="btn-wrapper--icon">
                              <FontAwesomeIcon
                                icon={['fas', 'external-link-alt']}
                              />
                            </span>
                            <span className="btn-wrapper--label">
                              PRO Version
                            </span>
                          </Button>
                        </div>
                        <small className="d-block pt-4">
                          For a comprehensive list of components &amp;
                          commercial licenses, we recommend the PRO version.
                        </small>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div className="container-fluid pt-5 px-5">
          <div className="row">
            <div className="col-xl-6 bg-premium-dark">
              <div className="p-0 p-lg-5">
                <IconsFontawesome />
              </div>
            </div>
            <div className="col-xl-6 bg-midnight-bloom">
              <div className="p-0 p-lg-5">
                <IconsPe7 />
              </div>
            </div>
          </div>
        </div>
        <div className="py-5 bg-secondary my-5">
          <div className="container">
            <div className="px-0 col-lg-8 col-md-10 col-sm-12 mx-auto text-center">
              <h1 className="display-3 mb-4 font-weight-bold">
                Bamburgh UI Kit is available for multiple frameworks
              </h1>
              <p className="font-size-lg text-black-50">
                Bamburgh is also available with integrations for the following
                frontend/backend frameworks:
              </p>
            </div>
          </div>
          <div className="container-fluid">
            <div className="mt-4 text-center d-flex flex-row flex-wrap justify-content-center">
              <div>
                <a
                  className="card card-box card-box-hover-rise px-2 pt-2 pb-3 m-3"
                  href="https://uifort.com/template/bamburgh-react-ui-kit-reactstrap-free"
                  title="Click to visit the presentation page for Bamburgh React version">
                  <b>Bamburgh for React</b>
                  <img
                    src="https://demo.uifort.com/github-static-assets/framework-logo/react-framework-logo.png"
                    alt="Bamburgh React UI Kit with Reactstrap Free"
                  />
                  <span className="text-black-50 details-helper">
                    Click for details
                  </span>
                </a>
              </div>
              <div>
                <a
                  className="card card-box card-box-hover-rise px-2 pt-2 pb-3 m-3"
                  href="https://uifort.com/template/bamburgh-react-ui-kit-reactstrap-free"
                  title="Click to visit the presentation page for Bamburgh Angular version">
                  <b>Bamburgh for Angular</b>
                  <img
                    src="https://demo.uifort.com/github-static-assets/framework-logo/angular-framework-logo.png"
                    alt="Bamburgh React UI Kit with Reactstrap Free"
                  />
                  <span className="text-black-50 details-helper">
                    Click for details
                  </span>
                </a>
              </div>
              <div>
                <div className="card card-box px-2 pt-2 pb-3 m-3 opacity-6">
                  <b>Bamburgh for Vue.js</b>
                  <img
                    src="https://demo.uifort.com/github-static-assets/framework-logo/vue-framework-logo.png"
                    alt="Bamburgh for Vue.js"
                  />
                  <i className="details-helper text-black-50">
                    Not yet available
                  </i>
                </div>
              </div>
              <div>
                <div className="card card-box px-2 pt-2 pb-3 m-3 opacity-6">
                  <b>Bamburgh for HTML5/jQuery</b>
                  <img
                    src="https://demo.uifort.com/github-static-assets/framework-logo/html-framework-logo.png"
                    alt="Bamburgh for HTML5/jQuery"
                  />
                  <i className="details-helper text-black-50">
                    Not yet available
                  </i>
                </div>
              </div>
              <div>
                <div className="card card-box px-2 pt-2 pb-3 m-3 opacity-6">
                  <b>Bamburgh for Laravel</b>
                  <img
                    src="https://demo.uifort.com/github-static-assets/framework-logo/laravel-framework-logo.png"
                    alt="Bamburgh for Laravel"
                  />
                  <i className="details-helper text-black-50">
                    Not yet available
                  </i>
                </div>
              </div>
              <div>
                <div className="card card-box px-2 pt-2 pb-3 m-3 opacity-6">
                  <b>Bamburgh for Node.js</b>
                  <img
                    src="https://demo.uifort.com/github-static-assets/framework-logo/nodejs-framework-logo.png"
                    alt="Bamburgh for Node.js"
                  />
                  <i className="details-helper text-black-50">
                    Not yet available
                  </i>
                </div>
              </div>
              <div>
                <div className="card card-box px-2 pt-2 pb-3 m-3 opacity-6">
                  <b>Bamburgh for ASP.NET</b>
                  <img
                    src="https://demo.uifort.com/github-static-assets/framework-logo/asp-framework-logo.png"
                    alt="Bamburgh for ASP.NET"
                  />
                  <i className="details-helper text-black-50">
                    Not yet available
                  </i>
                </div>
              </div>
              <div>
                <div className="card card-box px-2 pt-2 pb-3 m-3 opacity-6">
                  <b>Bamburgh for Nuxt.js</b>
                  <img
                    src="https://demo.uifort.com/github-static-assets/framework-logo/nuxtjs-framework-logo.png"
                    alt="Bamburgh for Nuxt.js"
                  />
                  <i className="details-helper text-black-50">
                    Not yet available
                  </i>
                </div>
              </div>
              <div>
                <div className="card card-box px-2 pt-2 pb-3 m-3 opacity-6">
                  <b>Bamburgh for Next.js</b>
                  <img
                    src="https://demo.uifort.com/github-static-assets/framework-logo/nextjs-framework-logo.png"
                    alt="Bamburgh for Next.js"
                  />
                  <i className="details-helper text-black-50">
                    Not yet available
                  </i>
                </div>
              </div>
              <div>
                <div className="card card-box px-2 pt-2 pb-3 m-3 opacity-6">
                  <b>Bamburgh for React Native</b>
                  <img
                    src="https://demo.uifort.com/github-static-assets/framework-logo/react-native-framework-logo.png"
                    alt="Bamburgh for React Native"
                  />
                  <i className="details-helper text-black-50">
                    Not yet available
                  </i>
                </div>
              </div>
              <div>
                <div className="card card-box px-2 pt-2 pb-3 m-3 opacity-6">
                  <b>Bamburgh for Flutter</b>
                  <img
                    src="https://demo.uifort.com/github-static-assets/framework-logo/flutter-framework-logo.png"
                    alt="Bamburgh for Flutter"
                  />
                  <i className="details-helper text-black-50">
                    Not yet available
                  </i>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div className="px-5">
          <div className="px-5">
            <div className="mb-5">
              <Buttons />
            </div>
            <div className="mb-5">
              <Dropdowns />
            </div>
            <div className="mb-5">
              <NavigationMenus />
            </div>
            <div className="mb-5">
              <ProgressBars />
            </div>
            <div className="mb-5">
              <Pagination />
            </div>
            <div className="mb-5">
              <Scrollable />
            </div>
            <div className="mb-5">
              <Badges />
            </div>
            <div className="mb-5">
              <Icons />
            </div>
            <div className="mb-5">
              <UtilitiesHelpers />
            </div>
            <div className="mb-5">
              <Cards3 />
            </div>
            <div className="mb-5">
              <ListGroups />
            </div>
            <div className="mb-5">
              <Modals />
            </div>
            <div className="mb-5">
              <Notifications />
            </div>
            <div className="mb-5">
              <Carousels />
            </div>
            <div className="mb-5">
              <Popovers />
            </div>
            <div className="mb-5">
              <Tooltips />
            </div>
            <div className="mb-5">
              <Tabs />
            </div>
            <div className="mb-5">
              <RegularTables1 />
            </div>
            <div className="mb-5">
              <RegularTables4 />
            </div>
            <div className="mb-5">
              <FormsLayout />
            </div>
            <div className="mb-5">
              <FormsControls />
            </div>
            <div className="mb-5">
              <ApexCharts />
            </div>
            <div className="mb-5">
              <Maps />
            </div>
          </div>
        </div>
      </div>
    </Fragment>
  );
};

export default LandingPage;
