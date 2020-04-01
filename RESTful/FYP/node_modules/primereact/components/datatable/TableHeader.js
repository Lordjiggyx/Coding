"use strict";

Object.defineProperty(exports, "__esModule", {
  value: true
});
exports.TableHeader = void 0;

var _react = _interopRequireWildcard(require("react"));

var _HeaderCell = require("./HeaderCell");

function _getRequireWildcardCache() { if (typeof WeakMap !== "function") return null; var cache = new WeakMap(); _getRequireWildcardCache = function _getRequireWildcardCache() { return cache; }; return cache; }

function _interopRequireWildcard(obj) { if (obj && obj.__esModule) { return obj; } var cache = _getRequireWildcardCache(); if (cache && cache.has(obj)) { return cache.get(obj); } var newObj = {}; if (obj != null) { var hasPropertyDescriptor = Object.defineProperty && Object.getOwnPropertyDescriptor; for (var key in obj) { if (Object.prototype.hasOwnProperty.call(obj, key)) { var desc = hasPropertyDescriptor ? Object.getOwnPropertyDescriptor(obj, key) : null; if (desc && (desc.get || desc.set)) { Object.defineProperty(newObj, key, desc); } else { newObj[key] = obj[key]; } } } } newObj.default = obj; if (cache) { cache.set(obj, newObj); } return newObj; }

function _typeof(obj) { if (typeof Symbol === "function" && typeof Symbol.iterator === "symbol") { _typeof = function _typeof(obj) { return typeof obj; }; } else { _typeof = function _typeof(obj) { return obj && typeof Symbol === "function" && obj.constructor === Symbol && obj !== Symbol.prototype ? "symbol" : typeof obj; }; } return _typeof(obj); }

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } }

function _createClass(Constructor, protoProps, staticProps) { if (protoProps) _defineProperties(Constructor.prototype, protoProps); if (staticProps) _defineProperties(Constructor, staticProps); return Constructor; }

function _possibleConstructorReturn(self, call) { if (call && (_typeof(call) === "object" || typeof call === "function")) { return call; } return _assertThisInitialized(self); }

function _assertThisInitialized(self) { if (self === void 0) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return self; }

function _getPrototypeOf(o) { _getPrototypeOf = Object.setPrototypeOf ? Object.getPrototypeOf : function _getPrototypeOf(o) { return o.__proto__ || Object.getPrototypeOf(o); }; return _getPrototypeOf(o); }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function"); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, writable: true, configurable: true } }); if (superClass) _setPrototypeOf(subClass, superClass); }

function _setPrototypeOf(o, p) { _setPrototypeOf = Object.setPrototypeOf || function _setPrototypeOf(o, p) { o.__proto__ = p; return o; }; return _setPrototypeOf(o, p); }

var TableHeader =
/*#__PURE__*/
function (_Component) {
  _inherits(TableHeader, _Component);

  function TableHeader() {
    _classCallCheck(this, TableHeader);

    return _possibleConstructorReturn(this, _getPrototypeOf(TableHeader).apply(this, arguments));
  }

  _createClass(TableHeader, [{
    key: "createHeaderCells",
    value: function createHeaderCells(columns, renderOptions) {
      var _this = this;

      return _react.default.Children.map(columns, function (column, i) {
        return _react.default.createElement(_HeaderCell.HeaderCell, {
          key: column.columnKey || column.field || i,
          columnProps: column.props,
          value: _this.props.value,
          onSort: _this.props.onSort,
          sortField: _this.props.sortField,
          sortOrder: _this.props.sortOrder,
          multiSortMeta: _this.props.multiSortMeta,
          resizableColumns: _this.props.resizableColumns,
          onColumnResizeStart: _this.props.onColumnResizeStart,
          onFilter: _this.props.onFilter,
          renderOptions: renderOptions,
          onHeaderCheckboxClick: _this.props.onHeaderCheckboxClick,
          headerCheckboxSelected: _this.props.headerCheckboxSelected,
          reorderableColumns: _this.props.reorderableColumns,
          onDragStart: _this.props.onColumnDragStart,
          onDragOver: _this.props.onColumnDragOver,
          onDragLeave: _this.props.onColumnDragLeave,
          onDrop: _this.props.onColumnDrop,
          filters: _this.props.filters,
          tabIndex: _this.props.tabIndex
        });
      });
    }
  }, {
    key: "hasColumnFilter",
    value: function hasColumnFilter(columns) {
      if (columns) {
        var _iteratorNormalCompletion = true;
        var _didIteratorError = false;
        var _iteratorError = undefined;

        try {
          for (var _iterator = columns[Symbol.iterator](), _step; !(_iteratorNormalCompletion = (_step = _iterator.next()).done); _iteratorNormalCompletion = true) {
            var col = _step.value;

            if (col.props.filter) {
              return true;
            }
          }
        } catch (err) {
          _didIteratorError = true;
          _iteratorError = err;
        } finally {
          try {
            if (!_iteratorNormalCompletion && _iterator.return != null) {
              _iterator.return();
            }
          } finally {
            if (_didIteratorError) {
              throw _iteratorError;
            }
          }
        }
      }

      return false;
    }
  }, {
    key: "render",
    value: function render() {
      var _this2 = this;

      var content;

      if (this.props.columnGroup) {
        var rows = _react.default.Children.toArray(this.props.columnGroup.props.children);

        content = rows.map(function (row, i) {
          return _react.default.createElement("tr", {
            key: i
          }, _this2.createHeaderCells(_react.default.Children.toArray(row.props.children), {
            filterOnly: false,
            renderFilter: true,
            renderHeaderCheckbox: true
          }));
        });
      } else {
        var columns = _react.default.Children.toArray(this.props.children);

        if (this.hasColumnFilter(columns)) {
          content = _react.default.createElement(_react.default.Fragment, null, _react.default.createElement("tr", null, this.createHeaderCells(columns, {
            filterOnly: false,
            renderFilter: false,
            renderHeaderCheckbox: false
          })), _react.default.createElement("tr", null, this.createHeaderCells(columns, {
            filterOnly: true,
            renderFilter: true,
            renderHeaderCheckbox: true
          })));
        } else {
          content = _react.default.createElement("tr", null, this.createHeaderCells(columns, {
            filterOnly: false,
            renderFilter: false,
            renderHeaderCheckbox: true
          }));
        }
      }

      return _react.default.createElement("thead", {
        className: "p-datatable-thead"
      }, content);
    }
  }]);

  return TableHeader;
}(_react.Component);

exports.TableHeader = TableHeader;