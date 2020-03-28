import React, { Component } from 'react';

import { CardBody, Card, CardHeader } from 'reactstrap';

export default class ExampleWrapperSimple extends Component {
  render() {
    return (
      <Card className="card-box mb-5">
        <CardHeader>
          <div className="card-header--title font-size-md font-weight-bold py-2">
            <b className="font-size-md">{this.props.sectionHeading}</b>
          </div>
        </CardHeader>
        <CardBody>{this.props.children}</CardBody>
      </Card>
    );
  }
}
