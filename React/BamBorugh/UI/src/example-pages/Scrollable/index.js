import React, { Fragment } from 'react';

import { PageTitle } from '../../layout-components';

import { ExampleWrapperSimple } from '../../layout-components';
import ScrollableBasic from '../../example-components/Scrollable/ScrollableBasic';
export default function Scrollable() {
  return (
    <Fragment>
      <PageTitle
        titleHeading="Scrollable"
        titleDescription="Add scrolling areas to any elements with custom scrollbars or default browser ones."
      />

      <ExampleWrapperSimple sectionHeading="Custom scrollbars & Sizing">
        <ScrollableBasic />
      </ExampleWrapperSimple>
    </Fragment>
  );
}
