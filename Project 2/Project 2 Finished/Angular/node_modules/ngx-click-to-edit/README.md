# ngx click to edit
[![Build Status](https://travis-ci.org/sijpesteijn/ngx-click-to-edit.svg?branch=master)](https://travis-ci.org/sijpesteijn/ngx-click-to-edit)
[![codecov](https://codecov.io/gh/sijpesteijn/ngx-click-to-edit/branch/master/graph/badge.svg)](https://codecov.io/gh/sijpesteijn/ngx-click-to-edit)
[![npm version](https://badge.fury.io/js/ngx-click-to-edit.svg)](http://badge.fury.io/js/ngx-click-to-edit)
[![devDependency Status](https://david-dm.org/sijpesteijn/ngx-click-to-edit/dev-status.svg)](https://david-dm.org/sijpesteijn/ngx-click-to-edit?type=dev)
[![GitHub issues](https://img.shields.io/github/issues/sijpesteijn/ngx-click-to-edit.svg)](https://github.com/sijpesteijn/ngx-click-to-edit/issues)
[![GitHub stars](https://img.shields.io/github/stars/sijpesteijn/ngx-click-to-edit.svg)](https://github.com/sijpesteijn/ngx-click-to-edit/stargazers)
[![GitHub license](https://img.shields.io/badge/license-MIT-blue.svg)](https://raw.githubusercontent.com/sijpesteijn/ngx-click-to-edit/master/LICENSE)

## [Demo](https://sijpesteijn.github.io/ngx-click-to-edit/standalone_demo)

## Table of contents

- [About](#about)
- [Installation](#installation)
- [Documentation](#documentation)
- [Development](#development)
- [License](#license)

## About



## Installation

Install through npm:
```
npm install --save ngx-click-to-edit
```

Then include in your apps module:

```typescript
import { Component, NgModule } from '@angular/core';
import { NgxClickToEditModule } from 'ngx-click-to-edit';

@NgModule({
  imports: [
    NgxClickToEditModule.forRoot()
  ]
})
export class MyModule {}
```

Finally use in one of your apps components:
```typescript
import { Component } from '@angular/core';

@Component({
  template: '<click-to-edit></click-to-edit>'
})
export class MyComponent {}
```

You may also find it useful to view the [demo source](https://github.com/sijpesteijn/ngx-click-to-edit/blob/master/demo/demo.component.ts).

### Usage without a module bundler
```
<script src="node_modules/ngx-click-to-edit/bundles/ngx-click-to-edit.umd.js"></script>
<script>
    // everything is exported ngxClickToEdit namespace
</script>
```

## Documentation
All documentation is auto-generated from the source via [compodoc](https://compodoc.github.io/compodoc/) and can be viewed here:
https://sijpesteijn.github.io/ngx-click-to-edit/docs/

## License

MIT
