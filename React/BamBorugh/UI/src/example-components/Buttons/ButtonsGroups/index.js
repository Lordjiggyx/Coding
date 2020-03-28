import React, { Fragment } from 'react';

import { Button } from 'reactstrap';

import { ButtonGroup } from 'reactstrap';

export default function LivePreviewExample() {
  return (
    <Fragment>
      <ButtonGroup>
        <Button color="primary">Left</Button>
        <Button active color="primary">
          Middle
        </Button>
        <Button color="primary">Right</Button>
      </ButtonGroup>
    </Fragment>
  );
}
