# react-animated-transitions

[![npm version](https://badge.fury.io/js/react-animated-transitions.svg)](https://badge.fury.io/js/react-animated-transitions)

<img src="https://raw.githubusercontent.com/sonaye/react-animated-transitions/master/demo.gif" width="600">

## Installation

`yarn add react-transition-group react-animated-transitions animate.css`

`animate.css` is optional, without it you will have to write your own transition presets. The package includes only a single preset out of the box (a simple fade transition).

## Usage

```javascript
import Animated from 'react-animated-transitions';

// animate a child (when mounted/unmounted)
<Animated>
  <Foo />
</Animated>

// animate a group of children
<Animated items>
  {foos.map(() => <Animated item><Foo /></Animated>)}
</Animated>
```

### With `animate.css` transition presets

[List of available animations](https://github.com/daneden/animate.css/blob/master/animate-config.json) in `animate.css`.

```javascript
import 'animate.css'; // once, you don't need it if you are using your custom presets
// you can also create a custom build with only the presets you are using

// you can use any combination
<Animated enter="fadeIn" exit="fadeOut" />
<Animated enter="tada" exit="zoomOut" />

// you can import presets individually as well
import 'animate.css/source/attention_seekers/tada.css';
import 'animate.css/source/zooming_exits/zoomOut.css';

// when you import individually, you need add the duration to your css

/* duration.css */

.animated {
  animation-duration: 1000ms;
}

import './duration.css'; // after individual imports
```

Presets are not needed for `<Animated items />`, you can use them with `<Animated />` and `<Animated item />`.

### With a custom transition preset

To pass a custom preset, you need to add its css first, which is based on [react-transition-group](https://github.com/reactjs/react-transition-group).

```css
/* foo.css */

.foo-appear,
.foo-enter {
  /* transition state at 0% */
}

.foo-appear-active,
.foo-enter-active {
  /* transition state at 100% */
  /* transition definition */
}

.foo-exit {
  /* transition state at 100% */
}

.foo-exit-active {
  /* transition state at 0% */
  /* transition definition */
}

/* example: fade.css */
.fade-appear,
.fade-enter {
  opacity: 0;
}

.fade-appear-active,
.fade-enter-active {
  opacity: 1;
  transition: opacity 400ms ease-in;
}

.fade-exit {
  opacity: 1;
}

.fade-exit-active {
  opacity: 0;
  transition: opacity 400ms ease-out;
}
```

Then in your JavaScript:

```javascript
import './foo.css';

<Animated preset="foo" />; // notice that foo is used as a unique identifier in the css
```

### Passing a custom timeout

The timeout should match the css transition duration.

```javascript
<Animated timeout={1000} /> // default is 1000ms

// different timeout for entrance and exit
<Animated timeout={{ enter: 750, exit: 500 }} />
```

### Overwriting `animate.css` default duration

`animate.css` presets have a default timeout of 1000ms, to change this number you can overwrite the css.

```css
/* overwrite.css */

/* global */
.animated {
  animation-duration: 3000ms;
}

/* specific */
.animated.fadeIn {
  animation-duration: 3000ms;
}
```

Then in your JavaScript:

```javascript
import './overwrite.css'; // make sure you include animate.css before this line

<Animated timeout={3000} />;
```

### Disabling animation

Sometimes you may want to prevent your component from animating, but it is still being wrapped in `<Animated />`.

```javascript
<Animated disabled />
```

## Examples

[![Edit 4ron7o8157](https://codesandbox.io/static/img/play-codesandbox.svg)](https://codesandbox.io/s/4ron7o8157)

Available [here](https://github.com/sonaye/react-animated-transitions/tree/master/src/examples).
