import React, { Fragment } from 'react';

import { Button } from 'reactstrap';

import { ButtonGroup } from 'reactstrap';

export default function LivePreviewExample() {
  return (
    <Fragment>
      <ButtonGroup size="sm" className="m-2">
        <Button color="primary">Left</Button>
        <Button active color="primary">
          Middle
        </Button>
        <Button color="primary">Right</Button>
      </ButtonGroup>

      <div className="divider my-2" />

      <ButtonGroup size="lg" className="m-2">
        <Button color="primary">Left</Button>
        <Button active color="primary">
          Middle
        </Button>
        <Button color="primary">Right</Button>
      </ButtonGroup>
    </Fragment>
  );
}
