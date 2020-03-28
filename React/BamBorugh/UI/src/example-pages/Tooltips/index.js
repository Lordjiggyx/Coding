import React, { Fragment } from 'react';

import { PageTitle } from '../../layout-components';

import { ExampleWrapperSimple } from '../../layout-components';
import TooltipsBasic from '../../example-components/Tooltips/TooltipsBasic';
export default function Tooltips() {
  return (
    <Fragment>
      <PageTitle
        titleHeading="Tooltips"
        titleDescription="The tooltip or infotip or a hint is a common graphical user interface element."
      />

      <ExampleWrapperSimple sectionHeading="Basic">
        <TooltipsBasic />
      </ExampleWrapperSimple>
    </Fragment>
  );
}
