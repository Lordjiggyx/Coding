# [2.0.0](https://gitlab.com/liquid-design/liquid-design-react/compare/v1.1.7...v2.0.0) (2020-03-11)


### chore

* **styled-components:** upgrade to styled-component v5.0.1 ([6200be1](https://gitlab.com/liquid-design/liquid-design-react/commit/6200be1b9340029534d9fd9f82ea48f4d9cc391c))


### BREAKING CHANGES

* **styled-components:** rename callbacks in Calendar and DatePicker

onStartDateSelect -> startDateSelect
onEndDateSelect -> endDateSelect
onStartDateChange -> startDateChange
onEndDateChange -> endDateChange

See https://github.com/styled-components/styled-components/issues/2218

## [1.1.7](https://gitlab.com/liquid-design/liquid-design-react/compare/v1.1.6...v1.1.7) (2020-02-06)


### Bug Fixes

* **ssr_support:** support ssr envs using guards for browser globals ([a0f571d](https://gitlab.com/liquid-design/liquid-design-react/commit/a0f571d1d331e2ffb7ae6533e418efc5ef42a656)), closes [#18](https://gitlab.com/liquid-design/liquid-design-react/issues/18)

## [1.1.6](https://gitlab.com/liquid-design/liquid-design-react/compare/v1.1.5...v1.1.6) (2020-02-06)


### Bug Fixes

* **terms_reminder:** resolves Cannot find module ... remindOfTerms.js ([09d5af4](https://gitlab.com/liquid-design/liquid-design-react/commit/09d5af42c9047cb85e7137484b3de684bd1f34fe))

## [1.1.5](https://gitlab.com/liquid-design/liquid-design-react/compare/v1.1.4...v1.1.5) (2020-02-06)


### Bug Fixes

* **bundle:** Reduce bundle size in es mode via code splitting ([0b72065](https://gitlab.com/liquid-design/liquid-design-react/commit/0b72065cf16df0bc77693b0fc00f51ff0d4d03fc))
* **bundle:** Reduce bundle size in es mode via code splitting ([78a3931](https://gitlab.com/liquid-design/liquid-design-react/commit/78a39316ff61be9343d827efd74041fd9d6dbb91))
* **datepicker:** Trigger prop function when dates are selected (fixes [#15](https://gitlab.com/liquid-design/liquid-design-react/issues/15)) ([2d09453](https://gitlab.com/liquid-design/liquid-design-react/commit/2d09453779aebcf747bfcb175f85cb04c780b4cf))

## [1.1.5-release.1](https://gitlab.com/liquid-design/liquid-design-react/compare/v1.1.4...v1.1.5-release.1) (2020-02-05)


### Bug Fixes

* **bundle:** Reduce bundle size in es mode via code splitting ([0b72065](https://gitlab.com/liquid-design/liquid-design-react/commit/0b72065cf16df0bc77693b0fc00f51ff0d4d03fc))
* **bundle:** Reduce bundle size in es mode via code splitting ([78a3931](https://gitlab.com/liquid-design/liquid-design-react/commit/78a39316ff61be9343d827efd74041fd9d6dbb91))
* **datepicker:** Trigger prop function when dates are selected (fixes [#15](https://gitlab.com/liquid-design/liquid-design-react/issues/15)) ([2d09453](https://gitlab.com/liquid-design/liquid-design-react/commit/2d09453779aebcf747bfcb175f85cb04c780b4cf))

## [1.1.4](https://gitlab.com/liquid-design/liquid-design-react/compare/v1.1.3...v1.1.4) (2019-10-31)


### Bug Fixes

* **pagination:** Invalid array length ([fd3e274](https://gitlab.com/liquid-design/liquid-design-react/commit/fd3e274)), closes [#11](https://gitlab.com/liquid-design/liquid-design-react/issues/11)

## [1.1.3](https://gitlab.com/liquid-design/liquid-design-react/compare/v1.1.2...v1.1.3) (2019-10-30)


### Bug Fixes

* **accordion:** accordion children click causing to close the accordion ([a196e74](https://gitlab.com/liquid-design/liquid-design-react/commit/a196e74)), closes [#7](https://gitlab.com/liquid-design/liquid-design-react/issues/7)
* **button:** Add prop to Button element allowing to use filled icons in buttons ([26eef74](https://gitlab.com/liquid-design/liquid-design-react/commit/26eef74)), closes [#3](https://gitlab.com/liquid-design/liquid-design-react/issues/3)
* **colors:** increase gray colors contrast for readability ([9cb95f8](https://gitlab.com/liquid-design/liquid-design-react/commit/9cb95f8))
* **filter:** callbacks onOptionDeselect, onOptionSelect, onSubmit not working consistently ([850bfc3](https://gitlab.com/liquid-design/liquid-design-react/commit/850bfc3)), closes [#4](https://gitlab.com/liquid-design/liquid-design-react/issues/4) [#5](https://gitlab.com/liquid-design/liquid-design-react/issues/5)
* **search:** Search bar component not allowing special characters ([ac3cc15](https://gitlab.com/liquid-design/liquid-design-react/commit/ac3cc15)), closes [#9](https://gitlab.com/liquid-design/liquid-design-react/issues/9)

# [1.1.0](https://gitlab.com/liquid-design/liquid-design-react/compare/v1.0.1...v1.1.0) (2019-02-05)


### Bug Fixes

* pagination fix on table with 100% width ([93e9200](https://gitlab.com/liquid-design/liquid-design-react/commit/93e9200))
* rename aux dirs and files as aux is a reserved name on Windows ([aad1f30](https://gitlab.com/liquid-design/liquid-design-react/commit/aad1f30)), closes [#1](https://gitlab.com/liquid-design/liquid-design-react/issues/1)


### Features

* searchBarPlaceholder property for 'Header' module ([52761ed](https://gitlab.com/liquid-design/liquid-design-react/commit/52761ed))

## [1.0.1](https://gitlab.com/liquid-design/liquid-design-react/compare/v1.0.0...v1.0.1) (2019-01-15)


### Bug Fixes

* rename aux dirs and files as aux is a reserved name on Windows ([6e7074f](https://gitlab.com/liquid-design/liquid-design-react/commit/6e7074f)), closes [#1](https://gitlab.com/liquid-design/liquid-design-react/issues/1)

# 1.0.0 (2018-12-12)


### Bug Fixes

* add active style for Button ([74ffeb3](https://gitlab.com/liquid-design/liquid-design-react/commit/74ffeb3))
* add classNames to Footer ([0e650dd](https://gitlab.com/liquid-design/liquid-design-react/commit/0e650dd))
* android fixes ([19b2672](https://gitlab.com/liquid-design/liquid-design-react/commit/19b2672))
* assorted bugfixes ([a28f12a](https://gitlab.com/liquid-design/liquid-design-react/commit/a28f12a))
* assorted bugfixes ([ed7fe72](https://gitlab.com/liquid-design/liquid-design-react/commit/ed7fe72))
* assorted fixes ([1151cd5](https://gitlab.com/liquid-design/liquid-design-react/commit/1151cd5))
* assorted fixes ([7717356](https://gitlab.com/liquid-design/liquid-design-react/commit/7717356))
* assorted fixes ([108a4ab](https://gitlab.com/liquid-design/liquid-design-react/commit/108a4ab))
* assorted fixes and refactors ([1bc3ea4](https://gitlab.com/liquid-design/liquid-design-react/commit/1bc3ea4))
* assorted IE/Edge bugs ([2a6e6b5](https://gitlab.com/liquid-design/liquid-design-react/commit/2a6e6b5))
* assorted tweaks ([772911c](https://gitlab.com/liquid-design/liquid-design-react/commit/772911c))
* better touch handling ([1697dd6](https://gitlab.com/liquid-design/liquid-design-react/commit/1697dd6))
* bugs in DatePicker ([d3dfe46](https://gitlab.com/liquid-design/liquid-design-react/commit/d3dfe46))
* bugs in DatePicker/Calendar ([230def1](https://gitlab.com/liquid-design/liquid-design-react/commit/230def1))
* calendar appointment dot misplacement fix ([c1e5a8d](https://gitlab.com/liquid-design/liquid-design-react/commit/c1e5a8d))
* changed icon vertical alignment in list ([a529127](https://gitlab.com/liquid-design/liquid-design-react/commit/a529127))
* checkbox ([bfbde6d](https://gitlab.com/liquid-design/liquid-design-react/commit/bfbde6d))
* checkbox in form story hover ([7f18f9b](https://gitlab.com/liquid-design/liquid-design-react/commit/7f18f9b))
* classname generation & Header update ([b279132](https://gitlab.com/liquid-design/liquid-design-react/commit/b279132))
* components customisation & tweaks ([3318068](https://gitlab.com/liquid-design/liquid-design-react/commit/3318068))
* cursorValue tweak ([6f2aa4a](https://gitlab.com/liquid-design/liquid-design-react/commit/6f2aa4a))
* dropdown styling tweak ([b1c45a1](https://gitlab.com/liquid-design/liquid-design-react/commit/b1c45a1))
* fix calendar on ff mobile ([8ac004f](https://gitlab.com/liquid-design/liquid-design-react/commit/8ac004f))
* fix color bugs; add loki images ([22976b6](https://gitlab.com/liquid-design/liquid-design-react/commit/22976b6))
* fix filter on ie wrapping bug ([02489c8](https://gitlab.com/liquid-design/liquid-design-react/commit/02489c8))
* fix Icon not handling theme colors ([3bd659c](https://gitlab.com/liquid-design/liquid-design-react/commit/3bd659c))
* fix stateful radio button ([8f75982](https://gitlab.com/liquid-design/liquid-design-react/commit/8f75982))
* fixed 'i' and '!' icons in components to be consistent with designs ([423ca62](https://gitlab.com/liquid-design/liquid-design-react/commit/423ca62))
* fixed circular placeholder icon and optimised couple of svgs ([4ba0af1](https://gitlab.com/liquid-design/liquid-design-react/commit/4ba0af1))
* fixed mobile double tapping tooltip issue ([03beed3](https://gitlab.com/liquid-design/liquid-design-react/commit/03beed3))
* fixed safari tooltip click bug ([c345504](https://gitlab.com/liquid-design/liquid-design-react/commit/c345504))
* fixes for LineGraph, BarChart ([52d6341](https://gitlab.com/liquid-design/liquid-design-react/commit/52d6341))
* fixes for Pagination, Cards ([9a4e894](https://gitlab.com/liquid-design/liquid-design-react/commit/9a4e894))
* flyout indentation ([4157f44](https://gitlab.com/liquid-design/liquid-design-react/commit/4157f44))
* footer wrapping label fix ([ae7490b](https://gitlab.com/liquid-design/liquid-design-react/commit/ae7490b))
* handle development scripts on different platforms ([ac81af4](https://gitlab.com/liquid-design/liquid-design-react/commit/ac81af4))
* hotfixes ([9ea9fd6](https://gitlab.com/liquid-design/liquid-design-react/commit/9ea9fd6))
* icons files ([20fe15a](https://gitlab.com/liquid-design/liquid-design-react/commit/20fe15a))
* in TablePagination ([556ae66](https://gitlab.com/liquid-design/liquid-design-react/commit/556ae66))
* loki regressions ([65c25f3](https://gitlab.com/liquid-design/liquid-design-react/commit/65c25f3))
* missing icon in disabled list ([fbf66cc](https://gitlab.com/liquid-design/liquid-design-react/commit/fbf66cc))
* optimise & updated id's in svg illustrations ([45431d4](https://gitlab.com/liquid-design/liquid-design-react/commit/45431d4))
* remove console.log ([a2e5a56](https://gitlab.com/liquid-design/liquid-design-react/commit/a2e5a56))
* removed empty component proptypes from storybook ([13c268f](https://gitlab.com/liquid-design/liquid-design-react/commit/13c268f))
* safari ios center button fix ([b54f52d](https://gitlab.com/liquid-design/liquid-design-react/commit/b54f52d))
* safari mobile label alignment button fix ([ac10803](https://gitlab.com/liquid-design/liquid-design-react/commit/ac10803))
* slider box shadow fix ([dfcd05b](https://gitlab.com/liquid-design/liquid-design-react/commit/dfcd05b))
* slider buttons with external state fix ([750d610](https://gitlab.com/liquid-design/liquid-design-react/commit/750d610))
* table bugfix ([c8cf317](https://gitlab.com/liquid-design/liquid-design-react/commit/c8cf317))
* table fixes ([e9d029e](https://gitlab.com/liquid-design/liquid-design-react/commit/e9d029e))
* table styling ([267427a](https://gitlab.com/liquid-design/liquid-design-react/commit/267427a))
* tap highlight on modal on iOS Safari ([52f69a7](https://gitlab.com/liquid-design/liquid-design-react/commit/52f69a7))
* **$compile:** rollup watch fails change detection after first change ([453739c](https://gitlab.com/liquid-design/liquid-design-react/commit/453739c))
* **accordion:** modify an accordion ([1eaafbf](https://gitlab.com/liquid-design/liquid-design-react/commit/1eaafbf))
* **accordion:** modify padding ([9e55a8f](https://gitlab.com/liquid-design/liquid-design-react/commit/9e55a8f))
* **build:** Add s3-deploy to scripts ([5bf09a5](https://gitlab.com/liquid-design/liquid-design-react/commit/5bf09a5))
* **button:** fix font bug ([0a46adb](https://gitlab.com/liquid-design/liquid-design-react/commit/0a46adb))
* **ci:** fix build ([e8e2036](https://gitlab.com/liquid-design/liquid-design-react/commit/e8e2036))
* **ci:** hub command fix ([03235b4](https://gitlab.com/liquid-design/liquid-design-react/commit/03235b4))
* **headline:** modify the headline ([0808892](https://gitlab.com/liquid-design/liquid-design-react/commit/0808892))
* **loki:** investigate and fix loki differences ([2f6aaba](https://gitlab.com/liquid-design/liquid-design-react/commit/2f6aaba))
* **loki:** update refs; update BarChart ([b71eff0](https://gitlab.com/liquid-design/liquid-design-react/commit/b71eff0))
* **slider:** fix tooltip issue ([#160](https://gitlab.com/liquid-design/liquid-design-react/issues/160)) ([a5e50c5](https://gitlab.com/liquid-design/liquid-design-react/commit/a5e50c5))
* **storybook:** add storybook fixes ([dfd3478](https://gitlab.com/liquid-design/liquid-design-react/commit/dfd3478))
* **storybook:** scrolling stories list on mobile ([9a6db84](https://gitlab.com/liquid-design/liquid-design-react/commit/9a6db84))
* **themes:** white text color on secondary bg in richPurple theme ([39281fa](https://gitlab.com/liquid-design/liquid-design-react/commit/39281fa))
* colors in Card ([c4048f9](https://gitlab.com/liquid-design/liquid-design-react/commit/c4048f9))
* smaller clickable area on Favorite ([15b9d05](https://gitlab.com/liquid-design/liquid-design-react/commit/15b9d05))
* **storybook:** source displaying ([4019158](https://gitlab.com/liquid-design/liquid-design-react/commit/4019158))
* import in new component storybook template ([d68e34c](https://gitlab.com/liquid-design/liquid-design-react/commit/d68e34c))
* mulitple Card components case ([fcd96da](https://gitlab.com/liquid-design/liquid-design-react/commit/fcd96da))
* styling Breadcrumb ([a87f84f](https://gitlab.com/liquid-design/liquid-design-react/commit/a87f84f))
* styling Card ([38b53dd](https://gitlab.com/liquid-design/liquid-design-react/commit/38b53dd))
* styling Modal ([950a620](https://gitlab.com/liquid-design/liquid-design-react/commit/950a620))
* tooltip hotfix ([4ad5cdf](https://gitlab.com/liquid-design/liquid-design-react/commit/4ad5cdf))
* **storybook:** import Loki config only if needed ([2a62521](https://gitlab.com/liquid-design/liquid-design-react/commit/2a62521))
* handle changed default Icon size ([add0bf7](https://gitlab.com/liquid-design/liquid-design-react/commit/add0bf7))
* prevent notification flickering ([a2f5591](https://gitlab.com/liquid-design/liquid-design-react/commit/a2f5591))
* styling the Icon via pseudoselector ([fd3ae0c](https://gitlab.com/liquid-design/liquid-design-react/commit/fd3ae0c))
* svg icon file fix ([1c12f2e](https://gitlab.com/liquid-design/liquid-design-react/commit/1c12f2e))
* tweak in Ratings component ([3bfa9d5](https://gitlab.com/liquid-design/liquid-design-react/commit/3bfa9d5))
* tweak mobile styles for Header ([6c5e4da](https://gitlab.com/liquid-design/liquid-design-react/commit/6c5e4da))
* tweaks for Card, Badge components ([1b695a9](https://gitlab.com/liquid-design/liquid-design-react/commit/1b695a9))
* tweaks in Card, Badge ([333b41b](https://gitlab.com/liquid-design/liquid-design-react/commit/333b41b))
* update Breadcrumbs component ([2124867](https://gitlab.com/liquid-design/liquid-design-react/commit/2124867))


### Features

* add BarChart ([239baf4](https://gitlab.com/liquid-design/liquid-design-react/commit/239baf4))
* add CircularProgressBar component ([f542a3f](https://gitlab.com/liquid-design/liquid-design-react/commit/f542a3f))
* add code snippets to storybook ([3a78278](https://gitlab.com/liquid-design/liquid-design-react/commit/3a78278))
* add datepicker to forms ([a3eccfe](https://gitlab.com/liquid-design/liquid-design-react/commit/a3eccfe))
* add devdocs update ([4394d97](https://gitlab.com/liquid-design/liquid-design-react/commit/4394d97))
* add Dropdown component; Loki updates ([50f97f4](https://gitlab.com/liquid-design/liquid-design-react/commit/50f97f4))
* add Favorite element ([ff65a83](https://gitlab.com/liquid-design/liquid-design-react/commit/ff65a83))
* add Filters ([e54df40](https://gitlab.com/liquid-design/liquid-design-react/commit/e54df40))
* add FlyOut component ([699f7a7](https://gitlab.com/liquid-design/liquid-design-react/commit/699f7a7))
* add Forms module ([22b72db](https://gitlab.com/liquid-design/liquid-design-react/commit/22b72db))
* add LinearProgressBar ([88cc981](https://gitlab.com/liquid-design/liquid-design-react/commit/88cc981))
* add LineGraph ([0b22e24](https://gitlab.com/liquid-design/liquid-design-react/commit/0b22e24))
* add logos ([00ad123](https://gitlab.com/liquid-design/liquid-design-react/commit/00ad123))
* add Modal examples ([d7e22ad](https://gitlab.com/liquid-design/liquid-design-react/commit/d7e22ad))
* add ModalContent, SingleNotification to lib's exports ([496318a](https://gitlab.com/liquid-design/liquid-design-react/commit/496318a))
* add pagination simple ([34bab73](https://gitlab.com/liquid-design/liquid-design-react/commit/34bab73))
* add src directory to npm package distribution ([fa6ba28](https://gitlab.com/liquid-design/liquid-design-react/commit/fa6ba28))
* add StackedBarChart ([7d57834](https://gitlab.com/liquid-design/liquid-design-react/commit/7d57834))
* add StepProgressBar component ([f2dfa89](https://gitlab.com/liquid-design/liquid-design-react/commit/f2dfa89))
* add Table component ([263da77](https://gitlab.com/liquid-design/liquid-design-react/commit/263da77))
* add Table, TablePagination ([6b7cb68](https://gitlab.com/liquid-design/liquid-design-react/commit/6b7cb68))
* add TextField element ([daa2141](https://gitlab.com/liquid-design/liquid-design-react/commit/daa2141))
* added and updated icons and glyphs ([30307ee](https://gitlab.com/liquid-design/liquid-design-react/commit/30307ee))
* added social shares ([6e7fc61](https://gitlab.com/liquid-design/liquid-design-react/commit/6e7fc61))
* assorted tweaks ([2921092](https://gitlab.com/liquid-design/liquid-design-react/commit/2921092))
* better SVG handling ([bb722cb](https://gitlab.com/liquid-design/liquid-design-react/commit/bb722cb))
* change checkbox icon colour ([e092eee](https://gitlab.com/liquid-design/liquid-design-react/commit/e092eee))
* change font weight to 900 on lists head ([f59d854](https://gitlab.com/liquid-design/liquid-design-react/commit/f59d854))
* change searchbar in header behaviour ([55d727e](https://gitlab.com/liquid-design/liquid-design-react/commit/55d727e))
* changed list functionality with disabled prop ([0df04e8](https://gitlab.com/liquid-design/liquid-design-react/commit/0df04e8))
* globally enable style customisation ([a0e0d30](https://gitlab.com/liquid-design/liquid-design-react/commit/a0e0d30))
* hide Table stories with TablePagination ([2f7e8d6](https://gitlab.com/liquid-design/liquid-design-react/commit/2f7e8d6))
* prepare handoff ([18edac6](https://gitlab.com/liquid-design/liquid-design-react/commit/18edac6))
* remove blank proptable wrappers from storybook ([6d6955f](https://gitlab.com/liquid-design/liquid-design-react/commit/6d6955f))
* remove hover styles on touch devices ([f0cc794](https://gitlab.com/liquid-design/liquid-design-react/commit/f0cc794))
* remove StackedBarChart from repository ([0720f98](https://gitlab.com/liquid-design/liquid-design-react/commit/0720f98))
* remove Tabs component from codebase ([38c3595](https://gitlab.com/liquid-design/liquid-design-react/commit/38c3595))
* replace sprite Favorite animation with programmatic one ([6dd6862](https://gitlab.com/liquid-design/liquid-design-react/commit/6dd6862))
* replaced checkboxFilled icon with new one ([c1659e8](https://gitlab.com/liquid-design/liquid-design-react/commit/c1659e8))
* rewrite Table: API, perf, allow external sorting ([082df96](https://gitlab.com/liquid-design/liquid-design-react/commit/082df96))
* temporarily hide DatePicker, TablePagination, Tabs ([85d2267](https://gitlab.com/liquid-design/liquid-design-react/commit/85d2267))
* tweak SearchBar ([be3a9c5](https://gitlab.com/liquid-design/liquid-design-react/commit/be3a9c5))
* tweak TextField ([844222a](https://gitlab.com/liquid-design/liquid-design-react/commit/844222a))
* **ci:** create pull request after publishing package ([d461ccd](https://gitlab.com/liquid-design/liquid-design-react/commit/d461ccd))
* **faq:** create faq ([6ffaacd](https://gitlab.com/liquid-design/liquid-design-react/commit/6ffaacd))
* **footer:** create a footer ([c5d9fed](https://gitlab.com/liquid-design/liquid-design-react/commit/c5d9fed))
* **header:** create a header ([c2d6bb0](https://gitlab.com/liquid-design/liquid-design-react/commit/c2d6bb0))
* **radiobutton:** create a radiobutton ([e83773e](https://gitlab.com/liquid-design/liquid-design-react/commit/e83773e))
* **slider:** create a slider ([d539639](https://gitlab.com/liquid-design/liquid-design-react/commit/d539639))
* **storybook:** change name, link and favicon ([4b3e825](https://gitlab.com/liquid-design/liquid-design-react/commit/4b3e825))
* **tabs:** create tabs ([cf4b29e](https://gitlab.com/liquid-design/liquid-design-react/commit/cf4b29e))
* add SearchBar component ([dc96346](https://gitlab.com/liquid-design/liquid-design-react/commit/dc96346))
* add Toggle component ([cbba82a](https://gitlab.com/liquid-design/liquid-design-react/commit/cbba82a))
* checkbox tweaks ([6880ab8](https://gitlab.com/liquid-design/liquid-design-react/commit/6880ab8))
* handle themes that have a dark secondary color ([5ff0bd0](https://gitlab.com/liquid-design/liquid-design-react/commit/5ff0bd0))
* **accordion:** create an accordion ([37db2e0](https://gitlab.com/liquid-design/liquid-design-react/commit/37db2e0))
* **bubble:** add animation ([#27](https://gitlab.com/liquid-design/liquid-design-react/issues/27)) ([84b8440](https://gitlab.com/liquid-design/liquid-design-react/commit/84b8440))
* **button:** create a button component ([91cdb60](https://gitlab.com/liquid-design/liquid-design-react/commit/91cdb60))
* **checkbox:** create a checkbox ([cb50b1a](https://gitlab.com/liquid-design/liquid-design-react/commit/cb50b1a))
* **components:** add Notifications component ([5383911](https://gitlab.com/liquid-design/liquid-design-react/commit/5383911))
* **components:** add Tag component ([13b6361](https://gitlab.com/liquid-design/liquid-design-react/commit/13b6361))
* **elements:** add bubble component ([d01d20b](https://gitlab.com/liquid-design/liquid-design-react/commit/d01d20b))
* **elements:** create Paragraph, Label and Link ([794e8a2](https://gitlab.com/liquid-design/liquid-design-react/commit/794e8a2))
* **list:** create a list component ([dc63c65](https://gitlab.com/liquid-design/liquid-design-react/commit/dc63c65))
* **quote:** create a quote component ([#32](https://gitlab.com/liquid-design/liquid-design-react/issues/32)) ([fd5d3eb](https://gitlab.com/liquid-design/liquid-design-react/commit/fd5d3eb))
* **quote:** create a quote component ([#47](https://gitlab.com/liquid-design/liquid-design-react/issues/47)) ([ff66555](https://gitlab.com/liquid-design/liquid-design-react/commit/ff66555))
* **theming:** add all themes and theme select in storybook ([3ed5d99](https://gitlab.com/liquid-design/liquid-design-react/commit/3ed5d99))
* add Breadcrumbs component ([bc511ae](https://gitlab.com/liquid-design/liquid-design-react/commit/bc511ae))
* add Card component ([1ac0535](https://gitlab.com/liquid-design/liquid-design-react/commit/1ac0535))
* add CSS reset ([a8c3f2c](https://gitlab.com/liquid-design/liquid-design-react/commit/a8c3f2c))
* add font antialiasing to global styles ([c6ad028](https://gitlab.com/liquid-design/liquid-design-react/commit/c6ad028))
* add minimum width to Card component ([f51b225](https://gitlab.com/liquid-design/liquid-design-react/commit/f51b225))
* add Modal component ([c6d715e](https://gitlab.com/liquid-design/liquid-design-react/commit/c6d715e))
* add new-component script for bootstraping new components [MER-13] ([54f072d](https://gitlab.com/liquid-design/liquid-design-react/commit/54f072d))
* add password for dynamic staging ([7ffb5da](https://gitlab.com/liquid-design/liquid-design-react/commit/7ffb5da))
* add Placeholder component; use it in ContentCard ([bfcd281](https://gitlab.com/liquid-design/liquid-design-react/commit/bfcd281))
* add Ratings component ([c34a13d](https://gitlab.com/liquid-design/liquid-design-react/commit/c34a13d))
* add SVG handling and Icon component [MER-1] ([c33a93c](https://gitlab.com/liquid-design/liquid-design-react/commit/c33a93c))
* Badge - handle icon and disabled props ([2d7f8fe](https://gitlab.com/liquid-design/liquid-design-react/commit/2d7f8fe))
* change Icon default size ([c1e83b8](https://gitlab.com/liquid-design/liquid-design-react/commit/c1e83b8))
* change rounding logic in Ratings ([5020de4](https://gitlab.com/liquid-design/liquid-design-react/commit/5020de4))
* ContentCard - bootstrap component ([c491832](https://gitlab.com/liquid-design/liquid-design-react/commit/c491832))
* styling cursor for disabled states ([8cd19b4](https://gitlab.com/liquid-design/liquid-design-react/commit/8cd19b4))
* **quote:** create a quote component ([#25](https://gitlab.com/liquid-design/liquid-design-react/issues/25)) ([f7f07ed](https://gitlab.com/liquid-design/liquid-design-react/commit/f7f07ed))
* allow different component types when using addComponent script ([17a578e](https://gitlab.com/liquid-design/liquid-design-react/commit/17a578e))
* ContentCard - add basic versions [MER-17] ([d7b691f](https://gitlab.com/liquid-design/liquid-design-react/commit/d7b691f))
* handle badge prop in ContentCard; tweak styling ([14a316d](https://gitlab.com/liquid-design/liquid-design-react/commit/14a316d))
* remove default theme from components ([7c79a5c](https://gitlab.com/liquid-design/liquid-design-react/commit/7c79a5c))
* SVG optimisation ([6d88228](https://gitlab.com/liquid-design/liquid-design-react/commit/6d88228))
* update Card, ContentCard components ([80bfc43](https://gitlab.com/liquid-design/liquid-design-react/commit/80bfc43))
* update Icon ([6079655](https://gitlab.com/liquid-design/liquid-design-react/commit/6079655))
* use Theme for global styles ([a7c4e40](https://gitlab.com/liquid-design/liquid-design-react/commit/a7c4e40))
* **components/Badge:** set up Badge component ([228651b](https://gitlab.com/liquid-design/liquid-design-react/commit/228651b))
* **Theme:** set up basic Theme implementation ([3315c44](https://gitlab.com/liquid-design/liquid-design-react/commit/3315c44))


### Reverts

* hiding DatePicker, TablePagination ([6b18529](https://gitlab.com/liquid-design/liquid-design-react/commit/6b18529))
* **css:** remove adding a css reset ([2d49bad](https://gitlab.com/liquid-design/liquid-design-react/commit/2d49bad))


* [MER-316] calendars simple (#116) ([e50fcd0](https://gitlab.com/liquid-design/liquid-design-react/commit/e50fcd0)), closes [#116](https://gitlab.com/liquid-design/liquid-design-react/issues/116)


### Performance Improvements

* added truncate string when text meets the end of the block ([f6aa702](https://gitlab.com/liquid-design/liquid-design-react/commit/f6aa702))


### BREAKING CHANGES

* Table's API has changed significantly. Instead of two-dimensional a array, the
`rows` prop takes now an array of objects.

MER-550
* new checkboxFilled icon
* dates-fns library, new components for Calendar and DatePicker

* feat: added basic calendar layout

MER-316

* feat: moved Calendar to a separate component

MER-316

* feat: ui fixes, withAppointments view

added ui fixes for large screens, implemented basic withAppointment view functionality

MER-316

* feat: mobile layout fixes

fixes for mobile layout, selection functionality fix

MER-316

* feat: added shallow components for calendar implementing

added shallow components for DatePicker, Calendar and styled shallow component for Calendar's
children, added library for dates management
* dates-fns library, new components for Calendar and DatePicker

* feat: moved Calendar to a separate component

MER-316

* feat: added props descriptions

MER-316

* feat: added shallow components for calendar implementing

added shallow components for DatePicker, Calendar and styled shallow component for Calendar's
children, added library for dates management
* dates-fns library, new components for Calendar and DatePicker

* feat: moved Calendar to a separate component

MER-316

* feat: adjusting calendar to the new code

updated branch with master, adjusted Calendar components code to overall style

MER-316

* feat: removed the consequences of rebasing

MER-316

* feat: updated loki tests

MER-316

* feat: implemented appointment tooltips

MER-316

* feat: moved calendar to modules

moved Calendar component to modules section according to description

MER-316

* fix: fixed linter errors

MER-316

* fix: cr fixes

fixed comments of reviewers

MER-316

* test: added tests for Calendar component

MER-316

* feat: replaced YearName div with TextField

replaced YearName div with TextField, added functionality of changing year, minor ui fixes

MER-316

* test: added missing tests

added test for date selection functionality and year change functionality

MER-316

* refactor: removed commented line

MER-316

* fix: cr fixes

removed withAppointments prop, fixed typo, css fixes

MER-316

* fix: cr fixes

fixes regarding namings, removing usage of unexisting prop

MER-316

* fix: added passing the date to outer component

MER-316

* fix: fixed bug with year displaying

fixed the issue with not updating year in TextField after changing the month to the one in the next
or previous year

MER-316

* fix: qa obligatory fixes

added code snippets to storybook, changed color for out of month days, added shadow for appointment
overlay

MER-316

* fix: qa small fixes

set static width for month name section, changed tooltips position so it didn't touch the day cell

MER-316

* fix: fixed issue with multiple selected dates in single date mode

MER-316

* fix: darkening the box-shadow of calendar

MER-316

* fix: updated snippets for storybook

removed wrapper div from code snippets

MER-316

* fix: fix for issue with dot hover

MER-316

* fix: qa fixes

fixed alignments according to fix in designs

MER-316

* fix: updates according to master changes

MER-316

* fix: qa fix

changed broken text alignment inside day cells

MER-316

* fix: qa fix for date cell alignment

MER-316

* fix: client required fixes

changed cells horizontal alignment, removed font transition on resizing

MER-316

* fix: moved apppintment dot to center

MER-316

* fix: fixed appointment dot alignment on the last cell in row

MER-316

<a name="1.4.0"></a>
# [1.4.0](https://gitlab.com/liquid-design/liquid-design-react/compare/v1.0.0...v1.4.0) (2018-10-29)


### Bug Fixes

* calendar appointment dot misplacement fix ([c1e5a8d](https://gitlab.com/liquid-design/liquid-design-react/commit/c1e5a8d))
* changed icon vertical alignment in list ([a529127](https://gitlab.com/liquid-design/liquid-design-react/commit/a529127))
* checkbox in form story hover ([7f18f9b](https://gitlab.com/liquid-design/liquid-design-react/commit/7f18f9b))
* fix filter on ie wrapping bug ([02489c8](https://gitlab.com/liquid-design/liquid-design-react/commit/02489c8))
* fixed circular placeholder icon and optimised couple of svgs ([4ba0af1](https://gitlab.com/liquid-design/liquid-design-react/commit/4ba0af1))
* flyout indentation ([4157f44](https://gitlab.com/liquid-design/liquid-design-react/commit/4157f44))
* missing icon in disabled list ([fbf66cc](https://gitlab.com/liquid-design/liquid-design-react/commit/fbf66cc))
* optimise & updated id's in svg illustrations ([45431d4](https://gitlab.com/liquid-design/liquid-design-react/commit/45431d4))
* remove console.log ([a2e5a56](https://gitlab.com/liquid-design/liquid-design-react/commit/a2e5a56))
* removed empty component proptypes from storybook ([13c268f](https://gitlab.com/liquid-design/liquid-design-react/commit/13c268f))
* safari mobile label alignment button fix ([ac10803](https://gitlab.com/liquid-design/liquid-design-react/commit/ac10803))
* table bugfix ([c8cf317](https://gitlab.com/liquid-design/liquid-design-react/commit/c8cf317))
* table styling ([267427a](https://gitlab.com/liquid-design/liquid-design-react/commit/267427a))


### Features

* add datepicker to forms ([a3eccfe](https://gitlab.com/liquid-design/liquid-design-react/commit/a3eccfe))
* add Filters ([e54df40](https://gitlab.com/liquid-design/liquid-design-react/commit/e54df40))
* hide Table stories with TablePagination ([2f7e8d6](https://gitlab.com/liquid-design/liquid-design-react/commit/2f7e8d6))
* replaced checkboxFilled icon with new one ([c1659e8](https://gitlab.com/liquid-design/liquid-design-react/commit/c1659e8))
* temporarily hide DatePicker, TablePagination, Tabs ([85d2267](https://gitlab.com/liquid-design/liquid-design-react/commit/85d2267))


### BREAKING CHANGES

* new checkboxFilled icon



<a name="1.0.0"></a>
# [1.0.0](https://gitlab.com/liquid-design/liquid-design-react/compare/228651b...v1.0.0) (2018-10-23)


* [MER-316] calendars simple (#116) ([e50fcd0](https://gitlab.com/liquid-design/liquid-design-react/commit/e50fcd0)), closes [#116](https://gitlab.com/liquid-design/liquid-design-react/issues/116)


### Bug Fixes

* assorted bugfixes ([ed7fe72](https://gitlab.com/liquid-design/liquid-design-react/commit/ed7fe72))
* assorted fixes ([108a4ab](https://gitlab.com/liquid-design/liquid-design-react/commit/108a4ab))
* assorted fixes ([7717356](https://gitlab.com/liquid-design/liquid-design-react/commit/7717356))
* assorted fixes ([1151cd5](https://gitlab.com/liquid-design/liquid-design-react/commit/1151cd5))
* assorted fixes and refactors ([1bc3ea4](https://gitlab.com/liquid-design/liquid-design-react/commit/1bc3ea4))
* assorted IE/Edge bugs ([2a6e6b5](https://gitlab.com/liquid-design/liquid-design-react/commit/2a6e6b5))
* checkbox ([bfbde6d](https://gitlab.com/liquid-design/liquid-design-react/commit/bfbde6d))
* classname generation & Header update ([b279132](https://gitlab.com/liquid-design/liquid-design-react/commit/b279132))
* colors in Card ([c4048f9](https://gitlab.com/liquid-design/liquid-design-react/commit/c4048f9))
* components customisation & tweaks ([3318068](https://gitlab.com/liquid-design/liquid-design-react/commit/3318068))
* cursorValue tweak ([6f2aa4a](https://gitlab.com/liquid-design/liquid-design-react/commit/6f2aa4a))
* fix color bugs; add loki images ([22976b6](https://gitlab.com/liquid-design/liquid-design-react/commit/22976b6))
* fix Icon not handling theme colors ([3bd659c](https://gitlab.com/liquid-design/liquid-design-react/commit/3bd659c))
* fix stateful radio button ([8f75982](https://gitlab.com/liquid-design/liquid-design-react/commit/8f75982))
* fixed 'i' and '!' icons in components to be consistent with designs ([423ca62](https://gitlab.com/liquid-design/liquid-design-react/commit/423ca62))
* fixed safari tooltip click bug ([c345504](https://gitlab.com/liquid-design/liquid-design-react/commit/c345504))
* handle changed default Icon size ([add0bf7](https://gitlab.com/liquid-design/liquid-design-react/commit/add0bf7))
* hotfixes ([9ea9fd6](https://gitlab.com/liquid-design/liquid-design-react/commit/9ea9fd6))
* icons files ([20fe15a](https://gitlab.com/liquid-design/liquid-design-react/commit/20fe15a))
* import in new component storybook template ([d68e34c](https://gitlab.com/liquid-design/liquid-design-react/commit/d68e34c))
* mulitple Card components case ([fcd96da](https://gitlab.com/liquid-design/liquid-design-react/commit/fcd96da))
* prevent notification flickering ([a2f5591](https://gitlab.com/liquid-design/liquid-design-react/commit/a2f5591))
* safari ios center button fix ([b54f52d](https://gitlab.com/liquid-design/liquid-design-react/commit/b54f52d))
* slider box shadow fix ([dfcd05b](https://gitlab.com/liquid-design/liquid-design-react/commit/dfcd05b))
* slider buttons with external state fix ([750d610](https://gitlab.com/liquid-design/liquid-design-react/commit/750d610))
* smaller clickable area on Favorite ([15b9d05](https://gitlab.com/liquid-design/liquid-design-react/commit/15b9d05))
* styling Breadcrumb ([a87f84f](https://gitlab.com/liquid-design/liquid-design-react/commit/a87f84f))
* styling Card ([38b53dd](https://gitlab.com/liquid-design/liquid-design-react/commit/38b53dd))
* styling Modal ([950a620](https://gitlab.com/liquid-design/liquid-design-react/commit/950a620))
* styling the Icon via pseudoselector ([fd3ae0c](https://gitlab.com/liquid-design/liquid-design-react/commit/fd3ae0c))
* svg icon file fix ([1c12f2e](https://gitlab.com/liquid-design/liquid-design-react/commit/1c12f2e))
* tooltip hotfix ([4ad5cdf](https://gitlab.com/liquid-design/liquid-design-react/commit/4ad5cdf))
* tweak in Ratings component ([3bfa9d5](https://gitlab.com/liquid-design/liquid-design-react/commit/3bfa9d5))
* tweak mobile styles for Header ([6c5e4da](https://gitlab.com/liquid-design/liquid-design-react/commit/6c5e4da))
* **accordion:** modify an accordion ([1eaafbf](https://gitlab.com/liquid-design/liquid-design-react/commit/1eaafbf))
* **accordion:** modify padding ([9e55a8f](https://gitlab.com/liquid-design/liquid-design-react/commit/9e55a8f))
* **button:** fix font bug ([0a46adb](https://gitlab.com/liquid-design/liquid-design-react/commit/0a46adb))
* **ci:** hub command fix ([03235b4](https://gitlab.com/liquid-design/liquid-design-react/commit/03235b4))
* **headline:** modify the headline  ([0808892](https://gitlab.com/liquid-design/liquid-design-react/commit/0808892))
* **loki:** investigate and fix loki differences ([2f6aaba](https://gitlab.com/liquid-design/liquid-design-react/commit/2f6aaba))
* **slider:** fix tooltip issue ([#160](https://gitlab.com/liquid-design/liquid-design-react/issues/160)) ([a5e50c5](https://gitlab.com/liquid-design/liquid-design-react/commit/a5e50c5))
* **storybook:** add storybook fixes ([dfd3478](https://gitlab.com/liquid-design/liquid-design-react/commit/dfd3478))
* tweaks for Card, Badge components ([1b695a9](https://gitlab.com/liquid-design/liquid-design-react/commit/1b695a9))
* tweaks in Card, Badge ([333b41b](https://gitlab.com/liquid-design/liquid-design-react/commit/333b41b))
* update Breadcrumbs component ([2124867](https://gitlab.com/liquid-design/liquid-design-react/commit/2124867))
* **storybook:** import Loki config only if needed ([2a62521](https://gitlab.com/liquid-design/liquid-design-react/commit/2a62521))
* **storybook:** source displaying ([4019158](https://gitlab.com/liquid-design/liquid-design-react/commit/4019158))
* **themes:** white text color on secondary bg in richPurple theme ([39281fa](https://gitlab.com/liquid-design/liquid-design-react/commit/39281fa))


### Features

* **accordion:** create an accordion ([37db2e0](https://gitlab.com/liquid-design/liquid-design-react/commit/37db2e0))
* **bubble:** add animation ([#27](https://gitlab.com/liquid-design/liquid-design-react/issues/27)) ([84b8440](https://gitlab.com/liquid-design/liquid-design-react/commit/84b8440))
* **button:** create a button component  ([91cdb60](https://gitlab.com/liquid-design/liquid-design-react/commit/91cdb60))
* **checkbox:** create a checkbox ([cb50b1a](https://gitlab.com/liquid-design/liquid-design-react/commit/cb50b1a))
* **ci:** create pull request after publishing package ([d461ccd](https://gitlab.com/liquid-design/liquid-design-react/commit/d461ccd))
* **components:** add Notifications component ([5383911](https://gitlab.com/liquid-design/liquid-design-react/commit/5383911))
* **components:** add Tag component  ([13b6361](https://gitlab.com/liquid-design/liquid-design-react/commit/13b6361))
* **components/Badge:** set up Badge component ([228651b](https://gitlab.com/liquid-design/liquid-design-react/commit/228651b))
* add Breadcrumbs component ([bc511ae](https://gitlab.com/liquid-design/liquid-design-react/commit/bc511ae))
* add Card component ([1ac0535](https://gitlab.com/liquid-design/liquid-design-react/commit/1ac0535))
* add CircularProgressBar component ([f542a3f](https://gitlab.com/liquid-design/liquid-design-react/commit/f542a3f))
* add code snippets to storybook ([3a78278](https://gitlab.com/liquid-design/liquid-design-react/commit/3a78278))
* add CSS reset ([a8c3f2c](https://gitlab.com/liquid-design/liquid-design-react/commit/a8c3f2c))
* add devdocs update ([4394d97](https://gitlab.com/liquid-design/liquid-design-react/commit/4394d97))
* add Dropdown component; Loki updates ([50f97f4](https://gitlab.com/liquid-design/liquid-design-react/commit/50f97f4))
* add Favorite element ([ff65a83](https://gitlab.com/liquid-design/liquid-design-react/commit/ff65a83))
* add FlyOut component ([699f7a7](https://gitlab.com/liquid-design/liquid-design-react/commit/699f7a7))
* add font antialiasing to global styles ([c6ad028](https://gitlab.com/liquid-design/liquid-design-react/commit/c6ad028))
* add Forms module ([22b72db](https://gitlab.com/liquid-design/liquid-design-react/commit/22b72db))
* add LinearProgressBar ([88cc981](https://gitlab.com/liquid-design/liquid-design-react/commit/88cc981))
* add minimum width to Card component ([f51b225](https://gitlab.com/liquid-design/liquid-design-react/commit/f51b225))
* add Modal component ([c6d715e](https://gitlab.com/liquid-design/liquid-design-react/commit/c6d715e))
* add Modal examples ([d7e22ad](https://gitlab.com/liquid-design/liquid-design-react/commit/d7e22ad))
* add ModalContent, SingleNotification to lib's exports ([496318a](https://gitlab.com/liquid-design/liquid-design-react/commit/496318a))
* add new-component script for bootstraping new components [MER-13] ([54f072d](https://gitlab.com/liquid-design/liquid-design-react/commit/54f072d))
* add pagination simple ([34bab73](https://gitlab.com/liquid-design/liquid-design-react/commit/34bab73))
* add password for dynamic staging ([7ffb5da](https://gitlab.com/liquid-design/liquid-design-react/commit/7ffb5da))
* add Placeholder component; use it in ContentCard ([bfcd281](https://gitlab.com/liquid-design/liquid-design-react/commit/bfcd281))
* add Ratings component ([c34a13d](https://gitlab.com/liquid-design/liquid-design-react/commit/c34a13d))
* add SearchBar component ([dc96346](https://gitlab.com/liquid-design/liquid-design-react/commit/dc96346))
* add src directory to npm package distribution ([fa6ba28](https://gitlab.com/liquid-design/liquid-design-react/commit/fa6ba28))
* add StepProgressBar component ([f2dfa89](https://gitlab.com/liquid-design/liquid-design-react/commit/f2dfa89))
* add SVG handling and Icon component [MER-1] ([c33a93c](https://gitlab.com/liquid-design/liquid-design-react/commit/c33a93c))
* add Table component ([263da77](https://gitlab.com/liquid-design/liquid-design-react/commit/263da77))
* add Table, TablePagination ([6b7cb68](https://gitlab.com/liquid-design/liquid-design-react/commit/6b7cb68))
* add TextField element ([daa2141](https://gitlab.com/liquid-design/liquid-design-react/commit/daa2141))
* add Toggle component ([cbba82a](https://gitlab.com/liquid-design/liquid-design-react/commit/cbba82a))
* added and updated icons and glyphs  ([30307ee](https://gitlab.com/liquid-design/liquid-design-react/commit/30307ee))
* allow different component types when using addComponent script ([17a578e](https://gitlab.com/liquid-design/liquid-design-react/commit/17a578e))
* assorted tweaks ([2921092](https://gitlab.com/liquid-design/liquid-design-react/commit/2921092))
* Badge - handle icon and disabled props ([2d7f8fe](https://gitlab.com/liquid-design/liquid-design-react/commit/2d7f8fe))
* change font weight to 900 on lists head ([f59d854](https://gitlab.com/liquid-design/liquid-design-react/commit/f59d854))
* change Icon default size ([c1e83b8](https://gitlab.com/liquid-design/liquid-design-react/commit/c1e83b8))
* change rounding logic in Ratings ([5020de4](https://gitlab.com/liquid-design/liquid-design-react/commit/5020de4))
* changed list functionality with disabled prop ([0df04e8](https://gitlab.com/liquid-design/liquid-design-react/commit/0df04e8))
* checkbox tweaks ([6880ab8](https://gitlab.com/liquid-design/liquid-design-react/commit/6880ab8))
* ContentCard - add basic versions [MER-17] ([d7b691f](https://gitlab.com/liquid-design/liquid-design-react/commit/d7b691f))
* ContentCard - bootstrap component ([c491832](https://gitlab.com/liquid-design/liquid-design-react/commit/c491832))
* globally enable style customisation ([a0e0d30](https://gitlab.com/liquid-design/liquid-design-react/commit/a0e0d30))
* handle badge prop in ContentCard; tweak styling ([14a316d](https://gitlab.com/liquid-design/liquid-design-react/commit/14a316d))
* handle themes that have a dark secondary color ([5ff0bd0](https://gitlab.com/liquid-design/liquid-design-react/commit/5ff0bd0))
* prepare handoff ([18edac6](https://gitlab.com/liquid-design/liquid-design-react/commit/18edac6))
* remove default theme from components ([7c79a5c](https://gitlab.com/liquid-design/liquid-design-react/commit/7c79a5c))
* replace sprite Favorite animation with programmatic one ([6dd6862](https://gitlab.com/liquid-design/liquid-design-react/commit/6dd6862))
* styling cursor for disabled states ([8cd19b4](https://gitlab.com/liquid-design/liquid-design-react/commit/8cd19b4))
* SVG optimisation ([6d88228](https://gitlab.com/liquid-design/liquid-design-react/commit/6d88228))
* update Card, ContentCard components ([80bfc43](https://gitlab.com/liquid-design/liquid-design-react/commit/80bfc43))
* **elements:** add bubble component ([d01d20b](https://gitlab.com/liquid-design/liquid-design-react/commit/d01d20b))
* **elements:** create Paragraph, Label and Link  ([794e8a2](https://gitlab.com/liquid-design/liquid-design-react/commit/794e8a2))
* **faq:** create faq ([6ffaacd](https://gitlab.com/liquid-design/liquid-design-react/commit/6ffaacd))
* **footer:** create a footer ([c5d9fed](https://gitlab.com/liquid-design/liquid-design-react/commit/c5d9fed))
* **header:** create a header ([c2d6bb0](https://gitlab.com/liquid-design/liquid-design-react/commit/c2d6bb0))
* use Theme for global styles ([a7c4e40](https://gitlab.com/liquid-design/liquid-design-react/commit/a7c4e40))
* **list:** create a list component ([dc63c65](https://gitlab.com/liquid-design/liquid-design-react/commit/dc63c65))
* **quote:** create a quote component ([#25](https://gitlab.com/liquid-design/liquid-design-react/issues/25)) ([f7f07ed](https://gitlab.com/liquid-design/liquid-design-react/commit/f7f07ed))
* **quote:** create a quote component ([#32](https://gitlab.com/liquid-design/liquid-design-react/issues/32)) ([fd5d3eb](https://gitlab.com/liquid-design/liquid-design-react/commit/fd5d3eb))
* tweak TextField ([844222a](https://gitlab.com/liquid-design/liquid-design-react/commit/844222a))
* **quote:** create a quote component ([#47](https://gitlab.com/liquid-design/liquid-design-react/issues/47)) ([ff66555](https://gitlab.com/liquid-design/liquid-design-react/commit/ff66555))
* update Icon ([6079655](https://gitlab.com/liquid-design/liquid-design-react/commit/6079655))
* **radiobutton:** create a radiobutton ([e83773e](https://gitlab.com/liquid-design/liquid-design-react/commit/e83773e))
* **slider:** create a slider ([d539639](https://gitlab.com/liquid-design/liquid-design-react/commit/d539639))
* **storybook:** change name, link and favicon ([4b3e825](https://gitlab.com/liquid-design/liquid-design-react/commit/4b3e825))
* **tabs:** create tabs ([cf4b29e](https://gitlab.com/liquid-design/liquid-design-react/commit/cf4b29e))
* **Theme:** set up basic Theme implementation ([3315c44](https://gitlab.com/liquid-design/liquid-design-react/commit/3315c44))
* **theming:** add all themes and theme select in storybook ([3ed5d99](https://gitlab.com/liquid-design/liquid-design-react/commit/3ed5d99))


### Performance Improvements

* added truncate string when text meets the end of the block ([f6aa702](https://gitlab.com/liquid-design/liquid-design-react/commit/f6aa702))


### Reverts

* **css:** remove adding a css reset ([2d49bad](https://gitlab.com/liquid-design/liquid-design-react/commit/2d49bad))


### BREAKING CHANGES

* - Slider props:
  - withIcon -> withButtons
  - default value -> 0 instead of 50
- List:
  - remove icon, onClick props
  - change items prop to array of {name, iconName?, onClick?}
  - change listHead prop to {name, iconName?}
- TextList:
  - in items prop.- remove id key

Other changes:
- storybook
  - update code snippets etc;
  - sort stories by name
  - polyfill Fragment for addon-info, in order to remove console warning
- update new component template to use propTable
- fix SVG files
- update Loki refs

MER-360
* dates-fns library, new components for Calendar and DatePicker

* feat: added basic calendar layout

MER-316

* feat: moved Calendar to a separate component

MER-316

* feat: ui fixes, withAppointments view

added ui fixes for large screens, implemented basic withAppointment view functionality

MER-316

* feat: mobile layout fixes

fixes for mobile layout, selection functionality fix

MER-316

* feat: added shallow components for calendar implementing

added shallow components for DatePicker, Calendar and styled shallow component for Calendar's
children, added library for dates management
* dates-fns library, new components for Calendar and DatePicker

* feat: moved Calendar to a separate component

MER-316

* feat: added props descriptions

MER-316

* feat: added shallow components for calendar implementing

added shallow components for DatePicker, Calendar and styled shallow component for Calendar's
children, added library for dates management
* dates-fns library, new components for Calendar and DatePicker

* feat: moved Calendar to a separate component

MER-316

* feat: adjusting calendar to the new code

updated branch with master, adjusted Calendar components code to overall style

MER-316

* feat: removed the consequences of rebasing

MER-316

* feat: updated loki tests

MER-316

* feat: implemented appointment tooltips

MER-316

* feat: moved calendar to modules

moved Calendar component to modules section according to description

MER-316

* fix: fixed linter errors

MER-316

* fix: cr fixes

fixed comments of reviewers

MER-316

* test: added tests for Calendar component

MER-316

* feat: replaced YearName div with TextField

replaced YearName div with TextField, added functionality of changing year, minor ui fixes

MER-316

* test: added missing tests

added test for date selection functionality and year change functionality

MER-316

* refactor: removed commented line

MER-316

* fix: cr fixes

removed withAppointments prop, fixed typo, css fixes

MER-316

* fix: cr fixes

fixes regarding namings, removing usage of unexisting prop

MER-316

* fix: added passing the date to outer component

MER-316

* fix: fixed bug with year displaying

fixed the issue with not updating year in TextField after changing the month to the one in the next
or previous year

MER-316

* fix: qa obligatory fixes

added code snippets to storybook, changed color for out of month days, added shadow for appointment
overlay

MER-316

* fix: qa small fixes

set static width for month name section, changed tooltips position so it didn't touch the day cell

MER-316

* fix: fixed issue with multiple selected dates in single date mode

MER-316

* fix: darkening the box-shadow of calendar

MER-316

* fix: updated snippets for storybook

removed wrapper div from code snippets

MER-316

* fix: fix for issue with dot hover

MER-316

* fix: qa fixes

fixed alignments according to fix in designs

MER-316

* fix: updates according to master changes

MER-316

* fix: qa fix

changed broken text alignment inside day cells

MER-316

* fix: qa fix for date cell alignment

MER-316

* fix: client required fixes

changed cells horizontal alignment, removed font transition on resizing

MER-316

* fix: moved apppintment dot to center

MER-316

* fix: fixed appointment dot alignment on the last cell in row

MER-316
