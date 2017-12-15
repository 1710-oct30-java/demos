(function (global, factory) {
	typeof exports === 'object' && typeof module !== 'undefined' ? factory(exports, require('@angular/core'), require('@angular/common'), require('@angular/forms')) :
	typeof define === 'function' && define.amd ? define(['exports', '@angular/core', '@angular/common', '@angular/forms'], factory) :
	(factory((global['@qontu/ngx-inline-editor'] = {}),global._angular_core,global._angular_common,global._angular_forms));
}(this, (function (exports,_angular_core,_angular_common,_angular_forms) { 'use strict';

var __extends = (undefined && undefined.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var InlineEditorService = (function () {
    /**
     * @param {?} events
     * @param {?=} config
     */
    function InlineEditorService(events, config) {
        var _this = this;
        this.events = events;
        this.config = config;
        this.onUpdateStateOfService = new _angular_core.EventEmitter();
        this.subscriptions = {};
        this.subscriptions.onUpdateStateSubscription = this.onUpdateStateOfService.subscribe(function (state) { return _this.state = state; });
    }
    /**
     * @param {?} config
     * @return {?}
     */
    InlineEditorService.prototype.setConfig = function (config) {
        this.config = config;
    };
    /**
     * @return {?}
     */
    InlineEditorService.prototype.getConfig = function () {
        return this.config;
    };
    /**
     * @return {?}
     */
    InlineEditorService.prototype.getState = function () {
        return this.state.clone();
    };
    /**
     * @return {?}
     */
    InlineEditorService.prototype.destroy = function () {
        Object.values(this.subscriptions).forEach(function (subscription) { return subscription.unsubscribe(); });
    };
    return InlineEditorService;
}());
var InputBase = (function () {
    /**
     * @param {?} injector
     */
    function InputBase(injector) {
        var _this = this;
        this.injector = injector;
        this.isNumeric = false;
        this.isRegexTestable = false;
        this.isLengthTestable = false;
        this.subscriptions = {};
        this.renderer = injector.get(_angular_core.Renderer);
        this.service = injector.get(InlineEditorService);
        this.cd = injector.get(_angular_core.ChangeDetectorRef);
        this.onUpdateConfig(this.service.getConfig());
        this.state = this.service.getState().clone();
        this.subscriptions.onUpdateConfigSubcription = this.service.events.internal.onUpdateConfig.subscribe(function (config) { return _this.onUpdateConfig(config); });
        this.subscriptions.onUpdateStateSubscription = this.service.events.internal.onUpdateStateOfChild.subscribe(function (state) {
            var newState = state.getState();
            _this.updateState(_this.state.newState(Object.assign({}, newState, { empty: _this.isEmpty(newState.value) })));
            _this.service.events.internal.onUpdateStateOfParent.emit(_this.state.clone());
        });
    }
    Object.defineProperty(InputBase.prototype, "value", {
        /**
         * @return {?}
         */
        get: function () {
            return this.state.getState().value;
        },
        /**
         * @param {?} value
         * @return {?}
         */
        set: function (value) {
            if (this.value === value) {
                return;
            }
            this.updateState(this.state.newState(Object.assign({}, this.state.getState(), { empty: this.isEmpty(value), value: value })));
            this.service.events.internal.onChange.emit({
                state: this.state.clone(),
            });
        },
        enumerable: true,
        configurable: true
    });
    /**
     * @return {?}
     */
    InputBase.prototype.ngOnChanges = function () { };
    /**
     * @return {?}
     */
    InputBase.prototype.ngOnInit = function () {
        this.inputElement = this.inputRef.nativeElement;
    };
    /**
     * @return {?}
     */
    InputBase.prototype.ngDoCheck = function () { };
    /**
     * @return {?}
     */
    InputBase.prototype.ngAfterContentInit = function () { };
    /**
     * @return {?}
     */
    InputBase.prototype.ngAfterContentChecked = function () { };
    /**
     * @return {?}
     */
    InputBase.prototype.ngAfterViewInit = function () { };
    /**
     * @return {?}
     */
    InputBase.prototype.ngAfterViewChecked = function () { };
    /**
     * @return {?}
     */
    InputBase.prototype.ngOnDestroy = function () {
        Object.values(this.subscriptions).forEach(function (subscription) { return subscription.unsubscribe(); });
    };
    /**
     * @param {?} newConfig
     * @return {?}
     */
    InputBase.prototype.onUpdateConfig = function (newConfig) {
        this.config = newConfig;
    };
    /**
     * @return {?}
     */
    InputBase.prototype.save = function () {
        this.service.events.internal.onSave.emit({
            state: this.state.clone(),
        });
    };
    /**
     * @return {?}
     */
    InputBase.prototype.cancel = function () {
        this.service.events.internal.onCancel.emit({
            state: this.state.clone(),
        });
    };
    /**
     * @param {?} event
     * @return {?}
     */
    InputBase.prototype.onEnter = function (event) {
        this.service.events.internal.onEnter.emit({
            event: event,
            state: this.state.clone(),
        });
    };
    /**
     * @param {?} event
     * @return {?}
     */
    InputBase.prototype.onEscape = function (event) {
        this.service.events.internal.onEscape.emit({
            event: event,
            state: this.state.clone(),
        });
    };
    /**
     * @param {?} event
     * @return {?}
     */
    InputBase.prototype.onBlur = function (event) {
        this.service.events.internal.onBlur.emit({
            event: event,
            state: this.state.clone(),
        });
    };
    /**
     * @param {?} event
     * @return {?}
     */
    InputBase.prototype.onClick = function (event) {
        this.service.events.internal.onClick.emit({
            event: event,
            state: this.state.clone(),
        });
    };
    /**
     * @param {?} event
     * @return {?}
     */
    InputBase.prototype.onKeyPress = function (event) {
        this.service.events.internal.onKeyPress.emit({
            event: event,
            state: this.state.clone(),
        });
    };
    /**
     * @param {?} event
     * @return {?}
     */
    InputBase.prototype.onFocus = function (event) {
        this.service.events.internal.onFocus.emit({
            event: event,
            state: this.state.clone(),
        });
    };
    /**
     * @return {?}
     */
    InputBase.prototype.checkValue = function () {
        var /** @type {?} */ errs = [];
        var value = this.state.getState().value;
        if (this.canTestRegex(this.config)) {
            if (!new RegExp(/** @type {?} */ (this.config.pattern)).test(value != null && value !== false ? value : '')) {
                errs.push({
                    type: "PATTERN_ERROR",
                    message: "Test pattern has failed",
                });
            }
        }
        if (this.canTestLength(this.config)) {
            var _a = this.config, min = _a.min, max = _a.max;
            var /** @type {?} */ length = value ? (this.isNumeric ? Number(value) : value.length) : 0;
            if (length < min || length > max) {
                errs.push({
                    type: "LENGTH_ERROR",
                    message: "Test length has failed",
                });
            }
        }
        return errs;
    };
    /**
     * @return {?}
     */
    InputBase.prototype.showText = function () {
        return this.state.isEmpty() ? this.config.empty : this.state.getState().value;
    };
    /**
     * @return {?}
     */
    InputBase.prototype.focus = function () {
        var _this = this;
        setTimeout(function () { return _this.renderer.invokeElementMethod(_this.inputElement, "focus", []); });
    };
    /**
     * @return {?}
     */
    InputBase.prototype.select = function () {
        var _this = this;
        setTimeout(function () { return _this.renderer.invokeElementMethod(_this.inputElement, "select", []); });
    };
    /**
     * @param {?} newState
     * @return {?}
     */
    InputBase.prototype.updateState = function (newState) {
        var _a = this.state.getState(), wasEmpty = _a.empty, wasDisabled = _a.disabled;
        if (newState.isEmpty() && newState.isEmpty() !== wasEmpty) {
            // onEmpty()
        }
        if (newState.isDisabled() && newState.isDisabled() !== wasDisabled) {
            // onDisabled()
        }
        this.state = newState;
        this.cd.markForCheck();
        this.service.onUpdateStateOfService.emit(this.state.clone());
    };
    /**
     * @param {?} value
     * @return {?}
     */
    InputBase.prototype.isEmpty = function (value) {
        return value == null || value === "";
    };
    /**
     * @param {?} config
     * @return {?}
     */
    InputBase.prototype.canTestRegex = function (config) {
        return this.isRegexTestable &&
            config.pattern != null &&
            (config.pattern instanceof RegExp || typeof config.pattern === "string");
    };
    /**
     * @param {?} config
     * @return {?}
     */
    InputBase.prototype.canTestLength = function (config) {
        return (this.isNumeric || this.isLengthTestable) &&
            (config.min != null || config.max != null);
    };
    return InputBase;
}());
InputBase.decorators = [
    { type: _angular_core.Component, args: [{
                template: " ",
                changeDetection: _angular_core.ChangeDetectionStrategy.OnPush,
            },] },
];
/**
 * @nocollapse
 */
InputBase.ctorParameters = function () { return [
    { type: _angular_core.Injector, },
]; };
InputBase.propDecorators = {
    'inputRef': [{ type: _angular_core.ViewChild, args: ["inputRef",] },],
};
var InputNumberComponent = (function (_super) {
    __extends(InputNumberComponent, _super);
    /**
     * @param {?} injector
     */
    function InputNumberComponent(injector) {
        var _this = _super.call(this, injector) || this;
        _this.isNumeric = true;
        return _this;
    }
    return InputNumberComponent;
}(InputBase));
InputNumberComponent.decorators = [
    { type: _angular_core.Component, args: [{
                selector: "inline-editor-number",
                styles: ["a {     text-decoration: none;     color: #428bca;     border-bottom: dashed 1px #428bca;     cursor: pointer;     line-height: 2;     margin-right: 5px;     margin-left: 5px; }   /* editable-empty */  .editable-empty, .editable-empty:hover, .editable-empty:focus, a.editable-empty, a.editable-empty:hover, a.editable-empty:focus {     font-style: italic;     color: #DD1144;     text-decoration: none; }  .inlineEditForm {     display: inline-block;     white-space: nowrap;     margin: 0; }  #inlineEditWrapper {     display: inline-block; }  .inlineEditForm input, select {     width: auto;     display: inline; }  .editInvalid {     color: #a94442;     margin-bottom: 0; }  .error {     border-color: #a94442; }  [hidden] {     display: none; }"],
                template: "<input #inputRef type=\"number\" class=\"form-control\" (keyup.enter)=\"onEnter($event)\"\n                (keyup.escape)=\"onEscape($event)\" (focus)=\"onFocus($event)\" (blur)=\"onBlur($event)\" (blur)=\"onBlur($event)\"\n                (keypress)=\"onKeyPress($event)\" [(ngModel)]=\"value\" [required]=\"config.required\"\n                [disabled]=\"state.isDisabled()\" [name]=\"config.name\" [placeholder]=\"config.placeholder\"\n                [size]=\"config.size\"/>",
                changeDetection: _angular_core.ChangeDetectionStrategy.OnPush,
            },] },
];
/**
 * @nocollapse
 */
InputNumberComponent.ctorParameters = function () { return [
    { type: _angular_core.Injector, },
]; };
var InputTextComponent = (function (_super) {
    __extends(InputTextComponent, _super);
    /**
     * @param {?} injector
     */
    function InputTextComponent(injector) {
        var _this = _super.call(this, injector) || this;
        _this.isRegexTestable = true;
        _this.isLengthTestable = true;
        return _this;
    }
    return InputTextComponent;
}(InputBase));
InputTextComponent.decorators = [
    { type: _angular_core.Component, args: [{
                selector: "inline-editor-text",
                styles: ["a {     text-decoration: none;     color: #428bca;     border-bottom: dashed 1px #428bca;     cursor: pointer;     line-height: 2;     margin-right: 5px;     margin-left: 5px; }   /* editable-empty */  .editable-empty, .editable-empty:hover, .editable-empty:focus, a.editable-empty, a.editable-empty:hover, a.editable-empty:focus {     font-style: italic;     color: #DD1144;     text-decoration: none; }  .inlineEditForm {     display: inline-block;     white-space: nowrap;     margin: 0; }  #inlineEditWrapper {     display: inline-block; }  .inlineEditForm input, select {     width: auto;     display: inline; }  .editInvalid {     color: #a94442;     margin-bottom: 0; }  .error {     border-color: #a94442; }  [hidden] {     display: none; }"],
                template: "<input #inputRef type=\"text\" (keyup.enter)=\"onEnter($event)\" (keyup.escape)=\"onEscape($event)\"\n                (focus)=\"onFocus($event)\" (blur)=\"onBlur($event)\" (click)=\"onClick($event)\" (keypress)=\"onKeyPress($event)\"\n                class=\"form-control\" [(ngModel)]=\"value\" [required]=\"config.required\"\n                [disabled]=\"state.isDisabled()\" [name]=\"config.name\" [placeholder]=\"config.placeholder\"\n                [size]=\"config.size\"/>",
                changeDetection: _angular_core.ChangeDetectionStrategy.OnPush,
            },] },
];
/**
 * @nocollapse
 */
InputTextComponent.ctorParameters = function () { return [
    { type: _angular_core.Injector, },
]; };
var InputPasswordComponent = (function (_super) {
    __extends(InputPasswordComponent, _super);
    /**
     * @param {?} injector
     */
    function InputPasswordComponent(injector) {
        var _this = _super.call(this, injector) || this;
        _this.isRegexTestable = true;
        _this.isLengthTestable = true;
        return _this;
    }
    /**
     * @return {?}
     */
    InputPasswordComponent.prototype.showText = function () {
        var /** @type {?} */ isEmpty = this.state.isEmpty();
        var /** @type {?} */ value = String(this.state.getState().value);
        return isEmpty ?
            this.config.empty :
            "*".repeat(value.length);
    };
    return InputPasswordComponent;
}(InputBase));
InputPasswordComponent.decorators = [
    { type: _angular_core.Component, args: [{
                selector: "inline-editor-password",
                styles: ["a {     text-decoration: none;     color: #428bca;     border-bottom: dashed 1px #428bca;     cursor: pointer;     line-height: 2;     margin-right: 5px;     margin-left: 5px; }   /* editable-empty */  .editable-empty, .editable-empty:hover, .editable-empty:focus, a.editable-empty, a.editable-empty:hover, a.editable-empty:focus {     font-style: italic;     color: #DD1144;     text-decoration: none; }  .inlineEditForm {     display: inline-block;     white-space: nowrap;     margin: 0; }  #inlineEditWrapper {     display: inline-block; }  .inlineEditForm input, select {     width: auto;     display: inline; }  .editInvalid {     color: #a94442;     margin-bottom: 0; }  .error {     border-color: #a94442; }  [hidden] {     display: none; }"],
                template: "<input #inputRef type=\"password\" class=\"form-control\" (keyup.enter)=\"onEnter($event)\"\n                (keyup.escape)=\"onEscape($event)\" (focus)=\"onFocus($event)\" (blur)=\"onBlur($event)\" (click)=\"onClick($event)\"\n                (keypress)=\"onKeyPress($event)\" [(ngModel)]=\"value\" [required]=\"config.required\"\n                [disabled]=\"state.isDisabled()\" [name]=\"config.name\" [placeholder]=\"config.placeholder\"\n                [size]=\"config.size\"/>",
                changeDetection: _angular_core.ChangeDetectionStrategy.OnPush,
            },] },
];
/**
 * @nocollapse
 */
InputPasswordComponent.ctorParameters = function () { return [
    { type: _angular_core.Injector, },
]; };
var InputRangeComponent = (function (_super) {
    __extends(InputRangeComponent, _super);
    /**
     * @param {?} injector
     */
    function InputRangeComponent(injector) {
        var _this = _super.call(this, injector) || this;
        _this.isNumeric = true;
        return _this;
    }
    return InputRangeComponent;
}(InputBase));
InputRangeComponent.decorators = [
    { type: _angular_core.Component, args: [{
                selector: "inline-editor-range",
                styles: ["a {     text-decoration: none;     color: #428bca;     border-bottom: dashed 1px #428bca;     cursor: pointer;     line-height: 2;     margin-right: 5px;     margin-left: 5px; }   /* editable-empty */  .editable-empty, .editable-empty:hover, .editable-empty:focus, a.editable-empty, a.editable-empty:hover, a.editable-empty:focus {     font-style: italic;     color: #DD1144;     text-decoration: none; }  .inlineEditForm {     display: inline-block;     white-space: nowrap;     margin: 0; }  #inlineEditWrapper {     display: inline-block; }  .inlineEditForm input, select {     width: auto;     display: inline; }  .editInvalid {     color: #a94442;     margin-bottom: 0; }  .error {     border-color: #a94442; }  [hidden] {     display: none; }"],
                template: "<input #inputRef type=\"range\" class=\"form-control\" (keyup.enter)=\"onEnter($event)\"\n                (keyup.escape)=\"onEscape($event)\" (focus)=\"onFocus($event)\" (blur)=\"onBlur($event)\" (click)=\"onClick($event)\"\n                (keypress)=\"onKeyPress($event)\" [(ngModel)]=\"value\" [required]=\"config.required\"\n                [disabled]=\"state.isDisabled()\" [name]=\"config.name\" [placeholder]=\"config.placeholder\"\n                [min]=\"config.min\" [max]=\"config.max\"/>",
                changeDetection: _angular_core.ChangeDetectionStrategy.OnPush,
            },] },
];
/**
 * @nocollapse
 */
InputRangeComponent.ctorParameters = function () { return [
    { type: _angular_core.Injector, },
]; };
var InputCheckboxComponent = (function (_super) {
    __extends(InputCheckboxComponent, _super);
    /**
     * @param {?} injector
     */
    function InputCheckboxComponent(injector) {
        return _super.call(this, injector) || this;
    }
    /**
     * @return {?}
     */
    InputCheckboxComponent.prototype.showText = function () {
        return this.value ? this.config.checkedText : this.config.uncheckedText;
    };
    return InputCheckboxComponent;
}(InputBase));
InputCheckboxComponent.decorators = [
    { type: _angular_core.Component, args: [{
                selector: "inline-editor-checkbox",
                styles: ["a {     text-decoration: none;     color: #428bca;     border-bottom: dashed 1px #428bca;     cursor: pointer;     line-height: 2;     margin-right: 5px;     margin-left: 5px; }   /* editable-empty */  .editable-empty, .editable-empty:hover, .editable-empty:focus, a.editable-empty, a.editable-empty:hover, a.editable-empty:focus {     font-style: italic;     color: #DD1144;     text-decoration: none; }  .inlineEditForm {     display: inline-block;     white-space: nowrap;     margin: 0; }  #inlineEditWrapper {     display: inline-block; }  .inlineEditForm input, select {     width: auto;     display: inline; }  .editInvalid {     color: #a94442;     margin-bottom: 0; }  .error {     border-color: #a94442; }  [hidden] {     display: none; }"],
                template: "<input #inputRef type=\"checkbox\" class=\"form-control\" (focus)=\"onFocus($event)\" (blur)=\"onBlur($event)\"\n                (keypress)=\"onKeyPress($event)\" [(ngModel)]=\"value\" [required]=\"config.required\"\n                [disabled]=\"state.isDisabled()\" [name]=\"config.name\"/>",
                changeDetection: _angular_core.ChangeDetectionStrategy.OnPush,
            },] },
];
/**
 * @nocollapse
 */
InputCheckboxComponent.ctorParameters = function () { return [
    { type: _angular_core.Injector, },
]; };
var InputTextareaComponent = (function (_super) {
    __extends(InputTextareaComponent, _super);
    /**
     * @param {?} injector
     */
    function InputTextareaComponent(injector) {
        var _this = _super.call(this, injector) || this;
        _this.isRegexTestable = true;
        _this.isLengthTestable = true;
        return _this;
    }
    return InputTextareaComponent;
}(InputBase));
InputTextareaComponent.decorators = [
    { type: _angular_core.Component, args: [{
                selector: "inline-editor-textarea",
                styles: ["a {     text-decoration: none;     color: #428bca;     border-bottom: dashed 1px #428bca;     cursor: pointer;     line-height: 2;     margin-right: 5px;     margin-left: 5px; }   /* editable-empty */  .editable-empty, .editable-empty:hover, .editable-empty:focus, a.editable-empty, a.editable-empty:hover, a.editable-empty:focus {     font-style: italic;     color: #DD1144;     text-decoration: none; }  .inlineEditForm {     display: inline-block;     white-space: nowrap;     margin: 0; }  #inlineEditWrapper {     display: inline-block; }  .inlineEditForm input, select {     width: auto;     display: inline; }  .editInvalid {     color: #a94442;     margin-bottom: 0; }  .error {     border-color: #a94442; }  [hidden] {     display: none; }"],
                template: "<textarea #inputRef class=\"form-control\" (keyup.enter)=\"onEnter($event)\"\n                (keyup.escape)=\"onEscape($event)\" (focus)=\"onFocus($event)\" (blur)=\"onBlur($event)\" (click)=\"onClick($event)\"\n                (keypress)=\"onKeyPress($event)\" [(ngModel)]=\"value\" [required]=\"config.required\"\n                [rows]=\"config.rows\" [cols]=\"config.cols\" [disabled]=\"state.isDisabled()\" [name]=\"config.name\"\n                [placeholder]=\"config.placeholder\"></textarea>",
                changeDetection: _angular_core.ChangeDetectionStrategy.OnPush,
            },] },
];
/**
 * @nocollapse
 */
InputTextareaComponent.ctorParameters = function () { return [
    { type: _angular_core.Injector, },
]; };
var InputSelectComponent = (function (_super) {
    __extends(InputSelectComponent, _super);
    /**
     * @param {?} injector
     */
    function InputSelectComponent(injector) {
        var _this = _super.call(this, injector) || this;
        _this.subscriptions.onUpdateConfigSubcription.unsubscribe();
        _this.subscriptions.onUpdateConfigSubcription = _this.service.events.internal.onUpdateConfig.subscribe(function (config) { return _this.onUpdateConfig(config); });
        return _this;
    }
    /**
     * @param {?} config
     * @return {?}
     */
    InputSelectComponent.prototype.onUpdateConfig = function (config) {
        _super.prototype.onUpdateConfig.call(this, config);
        var options = this.config.options;
        this.config.options = options instanceof Array ?
            {
                data: options,
                value: "value",
                text: "text",
            } : options;
        this.config = Object.assign({}, this.config);
    };
    /**
     * @return {?}
     */
    InputSelectComponent.prototype.showText = function () {
        var _a = this.config.options, keyOfText = _a.text, keyOfValue = _a.value, options = _a.data;
        var /** @type {?} */ currentValue = this.state.getState().value;
        var /** @type {?} */ optionSelected = this.getOptionSelected(currentValue, keyOfValue, options);
        return optionSelected ? optionSelected[keyOfText] : this.config.empty;
    };
    /**
     * @param {?} currentValue
     * @param {?} keyOfValue
     * @param {?} options
     * @return {?}
     */
    InputSelectComponent.prototype.getOptionSelected = function (currentValue, keyOfValue, options) {
        var /** @type {?} */ optionSelected;
        for (var _i = 0, options_1 = options; _i < options_1.length; _i++) {
            var option = options_1[_i];
            if (this.isAnOptionWithChildren(option)) {
                optionSelected = this.getOptionSelected(currentValue, keyOfValue, /** @type {?} */ ((option.children)));
            }
            else {
                var /** @type {?} */ typeOfValue = typeof option[keyOfValue];
                /**
                 * If the type is a number, the equal must be soft to match, ex:
                 *      1 == "1" -> true
                 *
                 * If the type is other, the equiality can be hard, because,
                 * when the currentValue is a string that contains "[object Object]"
                 * if you test it against an object, it will be true, ex:
                 * "[object Object]" == {} -> true
                 * "[object Object]" === {} -> false
                 *
                 */
                if (typeOfValue === "string" || typeOfValue === "number") {
                    // tslint:disable-next-line:triple-equals
                    optionSelected = option[keyOfValue] == currentValue ? option : undefined;
                }
                else {
                    optionSelected = option[keyOfValue] === currentValue ? option : undefined;
                }
            }
            if (optionSelected) {
                break;
            }
        }
        return optionSelected;
    };
    /**
     * @param {?} value
     * @return {?}
     */
    InputSelectComponent.prototype.isEmpty = function (value) {
        var _a = this.config.options, keyOfValue = _a.value, options = _a.data;
        return this.getOptionSelected(value, keyOfValue, options) == null;
    };
    /**
     * @param {?} options
     * @return {?}
     */
    InputSelectComponent.prototype.isAnOptionWithChildren = function (options) {
        return options.children != null && options.children instanceof Array;
    };
    return InputSelectComponent;
}(InputBase));
InputSelectComponent.decorators = [
    { type: _angular_core.Component, args: [{
                selector: "inline-editor-select",
                styles: ["a {     text-decoration: none;     color: #428bca;     border-bottom: dashed 1px #428bca;     cursor: pointer;     line-height: 2;     margin-right: 5px;     margin-left: 5px; }   /* editable-empty */  .editable-empty, .editable-empty:hover, .editable-empty:focus, a.editable-empty, a.editable-empty:hover, a.editable-empty:focus {     font-style: italic;     color: #DD1144;     text-decoration: none; }  .inlineEditForm {     display: inline-block;     white-space: nowrap;     margin: 0; }  #inlineEditWrapper {     display: inline-block; }  .inlineEditForm input, select {     width: auto;     display: inline; }  .editInvalid {     color: #a94442;     margin-bottom: 0; }  .error {     border-color: #a94442; }  [hidden] {     display: none; }"],
                template: "\n    <select #inputRef class=\"form-control\" [(ngModel)]=\"value\"\n    (focus)=\"onFocus($event)\" (keypress)=\"onKeyPress($event)\" (blur)=\"onBlur($event)\" (click)=\"onClick($event)\"\n    (keypress.enter)=\"onEnter($event)\" (keypress.escape)=\"onEscape($event)\" [disabled]=\"state.isDisabled()\">\n        <ng-template ngFor let-option [ngForOf]=\"config.options.data\">\n            <optgroup *ngIf=\"option.children\" [label]=\"option[config.options.text]\">\n                <option *ngFor=\"let child of option.children\" [ngValue]=\"child[config.options.value]\">\n                    {{child[config.options.text]}}\n                </option>\n            </optgroup>\n            <option *ngIf=\"!option.children\" [ngValue]=\"option[config.options.value]\">\n                {{option[config.options.text]}}\n            </option>\n        </ng-template>\n    </select>\n            ",
                changeDetection: _angular_core.ChangeDetectionStrategy.OnPush,
            },] },
];
/**
 * @nocollapse
 */
InputSelectComponent.ctorParameters = function () { return [
    { type: _angular_core.Injector, },
]; };
var InputDateComponent = (function (_super) {
    __extends(InputDateComponent, _super);
    /**
     * @param {?} injector
     */
    function InputDateComponent(injector) {
        var _this = _super.call(this, injector) || this;
        _this.isRegexTestable = true;
        return _this;
    }
    return InputDateComponent;
}(InputBase));
InputDateComponent.decorators = [
    { type: _angular_core.Component, args: [{
                selector: "inline-editor-date",
                styles: ["a {     text-decoration: none;     color: #428bca;     border-bottom: dashed 1px #428bca;     cursor: pointer;     line-height: 2;     margin-right: 5px;     margin-left: 5px; }   /* editable-empty */  .editable-empty, .editable-empty:hover, .editable-empty:focus, a.editable-empty, a.editable-empty:hover, a.editable-empty:focus {     font-style: italic;     color: #DD1144;     text-decoration: none; }  .inlineEditForm {     display: inline-block;     white-space: nowrap;     margin: 0; }  #inlineEditWrapper {     display: inline-block; }  .inlineEditForm input, select {     width: auto;     display: inline; }  .editInvalid {     color: #a94442;     margin-bottom: 0; }  .error {     border-color: #a94442; }  [hidden] {     display: none; }"],
                template: "<input #inputRef type=\"date\" class=\"form-control\" (keyup.enter)=\"onEnter($event)\"\n                (keyup.escape)=\"onEscape($event)\" (focus)=\"onFocus($event)\" (blur)=\"onBlur($event)\" (blur)=\"onBlur($event)\"\n                (keypress)=\"onKeyPress($event)\" [(ngModel)]=\"value\" [required]=\"config.required\"\n                [disabled]=\"state.isDisabled()\" [name]=\"config.name\" [placeholder]=\"config.placeholder\"\n                [size]=\"config.size\" [min]=\"config.min\" [max]=\"config.max\"/>",
                changeDetection: _angular_core.ChangeDetectionStrategy.OnPush,
            },] },
];
/**
 * @nocollapse
 */
InputDateComponent.ctorParameters = function () { return [
    { type: _angular_core.Injector, },
]; };
var InputTimeComponent = (function (_super) {
    __extends(InputTimeComponent, _super);
    /**
     * @param {?} injector
     */
    function InputTimeComponent(injector) {
        var _this = _super.call(this, injector) || this;
        _this.isRegexTestable = true;
        return _this;
    }
    return InputTimeComponent;
}(InputBase));
InputTimeComponent.decorators = [
    { type: _angular_core.Component, args: [{
                selector: "inline-editor-time",
                styles: ["a {     text-decoration: none;     color: #428bca;     border-bottom: dashed 1px #428bca;     cursor: pointer;     line-height: 2;     margin-right: 5px;     margin-left: 5px; }   /* editable-empty */  .editable-empty, .editable-empty:hover, .editable-empty:focus, a.editable-empty, a.editable-empty:hover, a.editable-empty:focus {     font-style: italic;     color: #DD1144;     text-decoration: none; }  .inlineEditForm {     display: inline-block;     white-space: nowrap;     margin: 0; }  #inlineEditWrapper {     display: inline-block; }  .inlineEditForm input, select {     width: auto;     display: inline; }  .editInvalid {     color: #a94442;     margin-bottom: 0; }  .error {     border-color: #a94442; }  [hidden] {     display: none; }"],
                template: "<input #inputRef type=\"time\" class=\"form-control\" (keyup.enter)=\"onEnter($event)\"\n                (keyup.escape)=\"onEscape($event)\" (focus)=\"onFocus($event)\" (blur)=\"onBlur($event)\" (click)=\"onClick($event)\"\n                (keypress)=\"onKeyPress($event)\" [(ngModel)]=\"value\" [required]=\"config.required\"\n                [disabled]=\"config.disabled\" [name]=\"config.name\" [placeholder]=\"config.placeholder\"\n                [size]=\"config.size\" [min]=\"config.min\" [max]=\"config.max\"/>",
                changeDetection: _angular_core.ChangeDetectionStrategy.OnPush,
            },] },
];
/**
 * @nocollapse
 */
InputTimeComponent.ctorParameters = function () { return [
    { type: _angular_core.Injector, },
]; };
var InputDatetimeComponent = (function (_super) {
    __extends(InputDatetimeComponent, _super);
    /**
     * @param {?} injector
     */
    function InputDatetimeComponent(injector) {
        var _this = _super.call(this, injector) || this;
        _this.isRegexTestable = true;
        return _this;
    }
    return InputDatetimeComponent;
}(InputBase));
InputDatetimeComponent.decorators = [
    { type: _angular_core.Component, args: [{
                selector: "inline-editor-datetime",
                styles: ["a {     text-decoration: none;     color: #428bca;     border-bottom: dashed 1px #428bca;     cursor: pointer;     line-height: 2;     margin-right: 5px;     margin-left: 5px; }   /* editable-empty */  .editable-empty, .editable-empty:hover, .editable-empty:focus, a.editable-empty, a.editable-empty:hover, a.editable-empty:focus {     font-style: italic;     color: #DD1144;     text-decoration: none; }  .inlineEditForm {     display: inline-block;     white-space: nowrap;     margin: 0; }  #inlineEditWrapper {     display: inline-block; }  .inlineEditForm input, select {     width: auto;     display: inline; }  .editInvalid {     color: #a94442;     margin-bottom: 0; }  .error {     border-color: #a94442; }  [hidden] {     display: none; }"],
                template: "<input #inputRef type=\"datetime-local\" class=\"form-control\" (keyup.enter)=\"onEnter($event)\"\n                (keyup.escape)=\"onEscape($event)\" (focus)=\"onFocus($event)\" (blur)=\"onBlur($event)\" (blur)=\"onBlur($event)\"\n                (keypress)=\"onKeyPress($event)\" [(ngModel)]=\"value\" [required]=\"config.required\"\n                [disabled]=\"state.isDisabled()\" [name]=\"config.name\" [placeholder]=\"config.placeholder\"\n                [size]=\"config.size\" [min]=\"config.min\" [max]=\"config.max\"/>",
                changeDetection: _angular_core.ChangeDetectionStrategy.OnPush,
            },] },
];
/**
 * @nocollapse
 */
InputDatetimeComponent.ctorParameters = function () { return [
    { type: _angular_core.Injector, },
]; };
var InternalEvents = (function () {
    function InternalEvents() {
        this.onUpdateStateOfParent = new _angular_core.EventEmitter();
        this.onUpdateStateOfChild = new _angular_core.EventEmitter();
        this.onChange = new _angular_core.EventEmitter();
        this.onFocus = new _angular_core.EventEmitter();
        this.onBlur = new _angular_core.EventEmitter();
        this.onKeyPress = new _angular_core.EventEmitter();
        this.onEnter = new _angular_core.EventEmitter();
        this.onEscape = new _angular_core.EventEmitter();
        this.onSave = new _angular_core.EventEmitter();
        this.onEdit = new _angular_core.EventEmitter();
        this.onCancel = new _angular_core.EventEmitter();
        this.onClick = new _angular_core.EventEmitter();
        this.onUpdateConfig = new _angular_core.EventEmitter();
    }
    return InternalEvents;
}());
var ExternalEvents = (function () {
    function ExternalEvents() {
        this.onChange = new _angular_core.EventEmitter();
        this.onSave = new _angular_core.EventEmitter();
        this.onKeyPress = new _angular_core.EventEmitter();
        this.onFocus = new _angular_core.EventEmitter();
        this.onBlur = new _angular_core.EventEmitter();
        this.onEnter = new _angular_core.EventEmitter();
        this.onEscape = new _angular_core.EventEmitter();
        this.onEdit = new _angular_core.EventEmitter();
        this.onCancel = new _angular_core.EventEmitter();
        this.onClick = new _angular_core.EventEmitter();
        this.onError = new _angular_core.EventEmitter();
    }
    return ExternalEvents;
}());
var InlineEditorState = (function () {
    /**
     * @param {?=} __0
     */
    function InlineEditorState(_a) {
        var _b = _a === void 0 ? { value: "" } : _a, value = _b.value, _c = _b.disabled, disabled = _c === void 0 ? false : _c, _d = _b.editing, editing = _d === void 0 ? false : _d, _e = _b.empty, empty = _e === void 0 ? false : _e;
        this.value = value;
        this.disabled = disabled;
        this.editing = editing;
        this.empty = empty;
    }
    /**
     * @param {?} state
     * @return {?}
     */
    InlineEditorState.prototype.newState = function (state) {
        return new InlineEditorState(state instanceof InlineEditorState ?
            state.getState() : state);
    };
    /**
     * @return {?}
     */
    InlineEditorState.prototype.getState = function () {
        var _a = this, value = _a.value, editing = _a.editing, disabled = _a.disabled, empty = _a.empty;
        return {
            value: value,
            editing: editing,
            disabled: disabled,
            empty: empty,
        };
    };
    /**
     * @return {?}
     */
    InlineEditorState.prototype.clone = function () {
        return this.newState(this);
    };
    /**
     * @return {?}
     */
    InlineEditorState.prototype.isEmpty = function () {
        return this.empty;
    };
    /**
     * @return {?}
     */
    InlineEditorState.prototype.isEditing = function () {
        return this.editing;
    };
    /**
     * @return {?}
     */
    InlineEditorState.prototype.isDisabled = function () {
        return this.disabled;
    };
    return InlineEditorState;
}());
var defaultConfig = {
    name: "",
    required: false,
    options: {
        data: [],
        text: "text",
        value: "value",
    },
    empty: "empty",
    placeholder: "placeholder",
    type: "text",
    size: 8,
    min: 0,
    max: Infinity,
    cols: 10,
    rows: 4,
    pattern: "",
    disabled: false,
    saveOnBlur: false,
    saveOnChange: false,
    saveOnEnter: true,
    editOnClick: true,
    cancelOnEscape: true,
    hideButtons: false,
    onlyValue: true,
    checkedText: "Check",
    uncheckedText: "Uncheck",
};
var InlineEditorComponent = (function () {
    /**
     * @param {?} componentFactoryResolver
     */
    function InlineEditorComponent(componentFactoryResolver) {
        this.componentFactoryResolver = componentFactoryResolver;
        this.events = {
            internal: new InternalEvents(),
            external: new ExternalEvents(),
        };
        this.onChange = this.events.external.onChange;
        this.onSave = this.events.external.onSave;
        this.onEdit = this.events.external.onEdit;
        this.onCancel = this.events.external.onCancel;
        this.onError = this.events.external.onError;
        this.onEnter = this.events.external.onEnter;
        this.onEscape = this.events.external.onEscape;
        this.onKeyPress = this.events.external.onKeyPress;
        this.onFocus = this.events.external.onFocus;
        this.onBlur = this.events.external.onBlur;
        this.onClick = this.events.external.onClick;
        this.subscriptions = {};
        this.components = {
            text: InputTextComponent,
            number: InputNumberComponent,
            password: InputPasswordComponent,
            range: InputRangeComponent,
            textarea: InputTextareaComponent,
            select: InputSelectComponent,
            date: InputDateComponent,
            time: InputTimeComponent,
            datetime: InputDatetimeComponent,
            checkbox: InputCheckboxComponent,
        };
        this.isEnterKeyPressed = false;
    }
    Object.defineProperty(InlineEditorComponent.prototype, "empty", {
        /**
         * @return {?}
         */
        get: function () {
            return this._empty;
        },
        /**
         * @param {?} empty
         * @return {?}
         */
        set: function (empty) {
            this._empty = empty;
            this.updateConfig(undefined, "empty", empty);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(InlineEditorComponent.prototype, "checkedText", {
        /**
         * @return {?}
         */
        get: function () {
            return this._checkedText;
        },
        /**
         * @param {?} checkedText
         * @return {?}
         */
        set: function (checkedText) {
            this._checkedText = checkedText;
            this.updateConfig(undefined, "checkedText", checkedText);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(InlineEditorComponent.prototype, "uncheckedText", {
        /**
         * @return {?}
         */
        get: function () {
            return this._uncheckedText;
        },
        /**
         * @param {?} uncheckedText
         * @return {?}
         */
        set: function (uncheckedText) {
            this._uncheckedText = uncheckedText;
            this.updateConfig(undefined, "uncheckedText", uncheckedText);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(InlineEditorComponent.prototype, "saveOnEnter", {
        /**
         * @return {?}
         */
        get: function () {
            return this._saveOnEnter;
        },
        /**
         * @param {?} saveOnEnter
         * @return {?}
         */
        set: function (saveOnEnter) {
            this._saveOnEnter = saveOnEnter;
            this.updateConfig(undefined, "saveOnEnter", saveOnEnter);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(InlineEditorComponent.prototype, "saveOnBlur", {
        /**
         * @return {?}
         */
        get: function () {
            return this._saveOnBlur;
        },
        /**
         * @param {?} saveOnBlur
         * @return {?}
         */
        set: function (saveOnBlur) {
            this._saveOnBlur = saveOnBlur;
            this.updateConfig(undefined, "saveOnBlur", saveOnBlur);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(InlineEditorComponent.prototype, "saveOnChange", {
        /**
         * @return {?}
         */
        get: function () {
            return this._saveOnChange;
        },
        /**
         * @param {?} saveOnChange
         * @return {?}
         */
        set: function (saveOnChange) {
            this._saveOnChange = saveOnChange;
            this.updateConfig(undefined, "saveOnChange", saveOnChange);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(InlineEditorComponent.prototype, "editOnClick", {
        /**
         * @return {?}
         */
        get: function () {
            return this._editOnClick;
        },
        /**
         * @param {?} editOnClick
         * @return {?}
         */
        set: function (editOnClick) {
            this._editOnClick = editOnClick;
            this.updateConfig(undefined, "editOnClick", editOnClick);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(InlineEditorComponent.prototype, "cancelOnEscape", {
        /**
         * @return {?}
         */
        get: function () {
            return this._cancelOnEscape;
        },
        /**
         * @param {?} cancelOnEscape
         * @return {?}
         */
        set: function (cancelOnEscape) {
            this._cancelOnEscape = cancelOnEscape;
            this.updateConfig(undefined, "cancelOnEscape", cancelOnEscape);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(InlineEditorComponent.prototype, "hideButtons", {
        /**
         * @return {?}
         */
        get: function () {
            return this._hideButtons;
        },
        /**
         * @param {?} hideButtons
         * @return {?}
         */
        set: function (hideButtons) {
            this._hideButtons = hideButtons;
            this.updateConfig(undefined, "hideButtons", hideButtons);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(InlineEditorComponent.prototype, "disabled", {
        /**
         * @return {?}
         */
        get: function () {
            return this._disabled;
        },
        /**
         * @param {?} disabled
         * @return {?}
         */
        set: function (disabled) {
            this._disabled = disabled;
            this.updateConfig(undefined, "disabled", disabled);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(InlineEditorComponent.prototype, "required", {
        /**
         * @return {?}
         */
        get: function () {
            return this._required;
        },
        /**
         * @param {?} required
         * @return {?}
         */
        set: function (required) {
            this._required = required;
            this.updateConfig(undefined, "required", required);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(InlineEditorComponent.prototype, "onlyValue", {
        /**
         * @return {?}
         */
        get: function () {
            return this._onlyValue;
        },
        /**
         * @param {?} onlyValue
         * @return {?}
         */
        set: function (onlyValue) {
            this._onlyValue = onlyValue;
            this.updateConfig(undefined, "onlyValue", onlyValue);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(InlineEditorComponent.prototype, "placeholder", {
        /**
         * @return {?}
         */
        get: function () {
            return this._placeholder;
        },
        /**
         * @param {?} placeholder
         * @return {?}
         */
        set: function (placeholder) {
            this._placeholder = placeholder;
            this.updateConfig(undefined, "placeholder", placeholder);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(InlineEditorComponent.prototype, "name", {
        /**
         * @return {?}
         */
        get: function () {
            return this._name;
        },
        /**
         * @param {?} name
         * @return {?}
         */
        set: function (name) {
            this._name = name;
            this.updateConfig(undefined, "name", name);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(InlineEditorComponent.prototype, "pattern", {
        /**
         * @return {?}
         */
        get: function () {
            return this._pattern;
        },
        /**
         * @param {?} pattern
         * @return {?}
         */
        set: function (pattern) {
            this._pattern = pattern;
            this.updateConfig(undefined, "pattern", pattern);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(InlineEditorComponent.prototype, "size", {
        /**
         * @return {?}
         */
        get: function () {
            return this._size;
        },
        /**
         * @param {?} size
         * @return {?}
         */
        set: function (size) {
            this._size = size;
            this.updateConfig(undefined, "size", size);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(InlineEditorComponent.prototype, "min", {
        /**
         * @return {?}
         */
        get: function () {
            return this._min;
        },
        /**
         * @param {?} min
         * @return {?}
         */
        set: function (min) {
            this._min = min;
            this.updateConfig(undefined, "min", min);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(InlineEditorComponent.prototype, "max", {
        /**
         * @return {?}
         */
        get: function () {
            return this._max;
        },
        /**
         * @param {?} max
         * @return {?}
         */
        set: function (max) {
            this._max = max;
            this.updateConfig(undefined, "max", max);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(InlineEditorComponent.prototype, "cols", {
        /**
         * @return {?}
         */
        get: function () {
            return this._cols;
        },
        /**
         * @param {?} cols
         * @return {?}
         */
        set: function (cols) {
            this._cols = cols;
            this.updateConfig(undefined, "cols", cols);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(InlineEditorComponent.prototype, "rows", {
        /**
         * @return {?}
         */
        get: function () {
            return this._rows;
        },
        /**
         * @param {?} rows
         * @return {?}
         */
        set: function (rows) {
            this._rows = rows;
            this.updateConfig(undefined, "rows", rows);
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(InlineEditorComponent.prototype, "options", {
        /**
         * @return {?}
         */
        get: function () {
            return this._options;
        },
        /**
         * @param {?} options
         * @return {?}
         */
        set: function (options) {
            this._options = options;
            this.updateConfig(undefined, "options", options);
        },
        enumerable: true,
        configurable: true
    });
    /**
     * @return {?}
     */
    InlineEditorComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.config = this.generateSafeConfig();
        this.state = new InlineEditorState({
            disabled: this.config.disabled,
            value: "",
        });
        this.service = new InlineEditorService(this.events, Object.assign({}, this.config));
        this.subscriptions.onUpdateStateSubcription = this.events.internal.onUpdateStateOfParent.subscribe(function (state) { return _this.state = state; });
        this.subscriptions.onSaveSubscription = this.events.internal.onSave.subscribe(function (_a) {
            var event = _a.event, state = _a.state;
            return _this.save({
                event: event,
                state: state.getState(),
            });
        });
        this.subscriptions.onCancelSubscription = this.events.internal.onCancel.subscribe(function (_a) {
            var event = _a.event, state = _a.state;
            return _this.cancel({
                event: event,
                state: state.getState(),
            });
        });
        this.subscriptions.onChangeSubcription = this.events.internal.onChange.subscribe(function (_a) {
            var event = _a.event, state = _a.state;
            if (_this.config.saveOnChange) {
                _this.saveAndClose({
                    event: event,
                    state: state.getState(),
                });
            }
            _this.emit(_this.onChange, {
                event: event,
                state: state.getState(),
            });
        });
        this.subscriptions.onKeyPressSubcription = this.events.internal.onKeyPress.subscribe(function (_a) {
            var event = _a.event, state = _a.state;
            return _this.emit(_this.onKeyPress, {
                event: event,
                state: state.getState(),
            });
        });
        this.subscriptions.onBlurSubscription = this.events.internal.onBlur.subscribe(function (_a) {
            var event = _a.event, state = _a.state;
            // TODO (xxxtonixx): Maybe, this approach is not the best,
            // because we need to set a class property and it is dangerous.
            // We should search for one better.
            var /** @type {?} */ isSavedByEnterKey = _this.isEnterKeyPressed && _this.config.saveOnEnter;
            if (_this.config.saveOnBlur && !isSavedByEnterKey) {
                _this.saveAndClose({
                    event: event,
                    state: state.getState(),
                });
            }
            _this.isEnterKeyPressed = false;
            _this.emit(_this.onBlur, {
                event: event,
                state: state.getState(),
            });
        });
        this.subscriptions.onClickSubcription = this.events.internal.onClick.subscribe(function (_a) {
            var event = _a.event, state = _a.state;
            return _this.emit(_this.onClick, {
                event: event,
                state: state.getState(),
            });
        });
        this.subscriptions.onFocusSubcription = this.events.internal.onFocus.subscribe(function (_a) {
            var event = _a.event, state = _a.state;
            return _this.emit(_this.onFocus, {
                event: event,
                state: state.getState(),
            });
        });
        this.subscriptions.onEnterSubscription = this.events.internal.onEnter.subscribe(function (_a) {
            var event = _a.event, state = _a.state;
            _this.isEnterKeyPressed = true;
            if (_this.config.saveOnEnter) {
                _this.save({
                    event: event,
                    state: state.getState(),
                });
                _this.edit({ editing: false });
            }
            _this.emit(_this.onEnter, {
                event: event,
                state: state.getState(),
            });
        });
        this.subscriptions.onEscapeSubscription = this.events.internal.onEscape.subscribe(function (_a) {
            var event = _a.event, state = _a.state;
            if (_this.config.cancelOnEscape) {
                _this.cancel({
                    event: event,
                    state: state.getState(),
                });
            }
            _this.emit(_this.onEscape, {
                event: event,
                state: state.getState(),
            });
        });
    };
    /**
     * @return {?}
     */
    InlineEditorComponent.prototype.ngAfterContentInit = function () {
        this.service.onUpdateStateOfService.emit(this.state.clone());
        this.generateComponent(this.config.type);
    };
    /**
     * @return {?}
     */
    InlineEditorComponent.prototype.ngOnDestroy = function () {
        Object.values(this.subscriptions).forEach(function (subscription) { return subscription.unsubscribe(); });
        this.currentComponent.destroy();
        this.service.destroy();
    };
    /**
     * @return {?}
     */
    InlineEditorComponent.prototype.validate = function () {
        var /** @type {?} */ errors = this.inputInstance ? this.inputInstance.checkValue() : [];
        return errors.length === 0 ? null : {
            InlineEditorError: {
                valid: false,
            },
        };
    };
    /**
     * @param {?} value
     * @return {?}
     */
    InlineEditorComponent.prototype.writeValue = function (value) {
        this.state = this.state.newState(Object.assign({}, this.state.getState(), { value: value }));
        this.events.internal.onUpdateStateOfChild.emit(this.state.clone());
    };
    /**
     * @param {?} refreshNGModel
     * @return {?}
     */
    InlineEditorComponent.prototype.registerOnChange = function (refreshNGModel) {
        this.refreshNGModel = refreshNGModel;
    };
    /**
     * @return {?}
     */
    InlineEditorComponent.prototype.registerOnTouched = function () { };
    /**
     * @param {?=} __0
     * @return {?}
     */
    InlineEditorComponent.prototype.edit = function (_a) {
        var _b = _a === void 0 ? {} : _a, _c = _b.editing, editing = _c === void 0 ? true : _c, _d = _b.focus, focus = _d === void 0 ? true : _d, _e = _b.select, select = _e === void 0 ? false : _e, event = _b.event;
        this.state = this.state.newState(Object.assign({}, this.state.getState(), { editing: editing }));
        this.events.internal.onUpdateStateOfChild.emit(this.state.clone());
        if (editing) {
            this.emit(this.onEdit, {
                event: event,
                state: this.state.getState(),
            });
        }
        if (editing && focus) {
            this.inputInstance.focus();
        }
        if (editing && select) {
            this.inputInstance.select();
        }
    };
    /**
     * @param {?} __0
     * @return {?}
     */
    InlineEditorComponent.prototype.save = function (_a) {
        var event = _a.event, hotState = _a.state;
        var /** @type {?} */ prevState = this.state.getState();
        var /** @type {?} */ state = Object.assign({}, prevState, hotState);
        var /** @type {?} */ errors = this.inputInstance.checkValue();
        if (errors.length !== 0) {
            this.onError.emit(errors);
        }
        else {
            this.state = this.state.newState(state);
            this.refreshNGModel(state.value);
            this.emit(this.onSave, {
                event: event,
                state: state,
            });
        }
    };
    /**
     * @param {?} outsideEvent
     * @return {?}
     */
    InlineEditorComponent.prototype.saveAndClose = function (outsideEvent) {
        this.save(outsideEvent);
        this.edit({ editing: false });
    };
    /**
     * @param {?} outsideEvent
     * @return {?}
     */
    InlineEditorComponent.prototype.cancel = function (outsideEvent) {
        this.edit({ editing: false });
        this.emit(this.onCancel, outsideEvent);
    };
    /**
     * @return {?}
     */
    InlineEditorComponent.prototype.getHotState = function () {
        return this.inputInstance.state.getState();
    };
    /**
     * @return {?}
     */
    InlineEditorComponent.prototype.showText = function () {
        return this.inputInstance ? this.inputInstance.showText() : "Loading...";
    };
    /**
     * @param {?} typeName
     * @return {?}
     */
    InlineEditorComponent.prototype.getComponentType = function (typeName) {
        var /** @type {?} */ type = this.components[typeName];
        if (!type) {
            throw new Error("That type does not exist or it is not implemented yet!");
        }
        return type;
    };
    /**
     * @param {?} type
     * @return {?}
     */
    InlineEditorComponent.prototype.generateComponent = function (type) {
        var /** @type {?} */ componentType = this.getComponentType(type);
        this.inputInstance = this.createInputInstance(componentType);
    };
    /**
     * @param {?} componentType
     * @return {?}
     */
    InlineEditorComponent.prototype.createInputInstance = function (componentType) {
        var /** @type {?} */ providers = _angular_core.ReflectiveInjector.resolve([{
                provide: InlineEditorService,
                useValue: this.service,
            }]);
        var /** @type {?} */ injector = _angular_core.ReflectiveInjector.fromResolvedProviders(providers, this.container.parentInjector);
        var /** @type {?} */ factory = this.componentFactoryResolver.resolveComponentFactory(componentType);
        this.componentRef = factory.create(injector);
        this.container.insert(this.componentRef.hostView);
        if (this.currentComponent) {
            this.currentComponent.destroy();
        }
        this.currentComponent = this.componentRef;
        return (this.componentRef.instance);
    };
    /**
     * @template T
     * @param {?} object
     * @return {?}
     */
    InlineEditorComponent.prototype.removeUndefinedProperties = function (object) {
        return JSON.parse(JSON.stringify(typeof object === "object" ? object : {}));
    };
    /**
     * @return {?}
     */
    InlineEditorComponent.prototype.generateSafeConfig = function () {
        var /** @type {?} */ configFromAttrs = {
            type: /** @type {?} */ ((this.type)),
            name: /** @type {?} */ ((this.name)),
            size: /** @type {?} */ ((this.size)),
            placeholder: /** @type {?} */ ((this.placeholder)),
            empty: /** @type {?} */ ((this.empty)),
            required: /** @type {?} */ ((this.required)),
            disabled: /** @type {?} */ ((this.disabled)),
            hideButtons: /** @type {?} */ ((this.hideButtons)),
            min: /** @type {?} */ ((this.min)),
            max: /** @type {?} */ ((this.max)),
            cols: /** @type {?} */ ((this.cols)),
            rows: /** @type {?} */ ((this.rows)),
            options: /** @type {?} */ ((this.options)),
            pattern: /** @type {?} */ ((this.pattern)),
            saveOnEnter: /** @type {?} */ ((this.saveOnEnter)),
            saveOnBlur: /** @type {?} */ ((this.saveOnBlur)),
            saveOnChange: /** @type {?} */ ((this.saveOnChange)),
            editOnClick: /** @type {?} */ ((this.editOnClick)),
            cancelOnEscape: /** @type {?} */ ((this.cancelOnEscape)),
            onlyValue: /** @type {?} */ ((this.onlyValue)),
            checkedText: /** @type {?} */ ((this.checkedText)),
            uncheckedText: /** @type {?} */ ((this.uncheckedText)),
        };
        return Object.assign({}, defaultConfig, this.removeUndefinedProperties(this.config), this.removeUndefinedProperties(configFromAttrs));
    };
    /**
     * @param {?=} config
     * @param {?=} property
     * @param {?=} value
     * @return {?}
     */
    InlineEditorComponent.prototype.updateConfig = function (config, property, value) {
        if (this.config) {
            config = config || this.config;
            if (property) {
                config[property] = value;
            }
            this.config = Object.assign({}, config);
            this.events.internal.onUpdateConfig.emit(this.config);
        }
    };
    /**
     * @param {?} event
     * @param {?} data
     * @return {?}
     */
    InlineEditorComponent.prototype.emit = function (event, data) {
        if (this.config.onlyValue) {
            event.emit(data.state.value);
        }
        else {
            ((event))
                .emit(Object.assign({}, data, { instance: this }));
        }
    };
    return InlineEditorComponent;
}());
InlineEditorComponent.decorators = [
    { type: _angular_core.Component, args: [{
                selector: "inline-editor",
                template: "<div id=\"inlineEditWrapper\">   <a [ngClass]=\"{'editable-empty': state.isEmpty(), 'c-inline-editor': true }\" (click)=\"!config.editOnClick || edit()\" [hidden]=\"state.isEditing() && !config.disabled\">{{ showText() }}</a>   <div class=\"c-inline-editor inlineEditForm form-inline\" [hidden]=\"!state.isEditing() || config.disabled\">     <div class=\"form-group\">       <div #container></div>       <span *ngIf=\"!config.hideButtons\" class=\"c-inline-editor inline-editor-button-group\">       <button id=\"inline-editor-button-save\" class=\"btn btn-xs btn-primary c-inline-editor\"           (click)=\"saveAndClose({ event: $event, state: service.getState() })\">           <span class=\"fa fa-check\"></span>       </button>       <button class=\"btn btn-xs btn-danger c-inline-editor\" (click)=\"cancel({ event: $event, state: service.getState() })\"><span class=\"fa fa-remove\"></span> </button>       </span>      </div>   </div> </div>",
                providers: [
                    {
                        provide: _angular_forms.NG_VALUE_ACCESSOR,
                        useExisting: _angular_core.forwardRef(function () { return InlineEditorComponent; }),
                        multi: true,
                    },
                    {
                        provide: _angular_forms.NG_VALIDATORS,
                        useExisting: _angular_core.forwardRef(function () { return InlineEditorComponent; }),
                        multi: true,
                    },
                ],
                entryComponents: [
                    InputTextComponent,
                    InputNumberComponent,
                    InputPasswordComponent,
                    InputRangeComponent,
                    InputTextareaComponent,
                    InputSelectComponent,
                    InputDateComponent,
                    InputTimeComponent,
                    InputDatetimeComponent,
                    InputCheckboxComponent,
                ],
                changeDetection: _angular_core.ChangeDetectionStrategy.OnPush,
            },] },
];
/**
 * @nocollapse
 */
InlineEditorComponent.ctorParameters = function () { return [
    { type: _angular_core.ComponentFactoryResolver, },
]; };
InlineEditorComponent.propDecorators = {
    'type': [{ type: _angular_core.Input },],
    'config': [{ type: _angular_core.Input },],
    'onChange': [{ type: _angular_core.Output },],
    'onSave': [{ type: _angular_core.Output },],
    'onEdit': [{ type: _angular_core.Output },],
    'onCancel': [{ type: _angular_core.Output },],
    'onError': [{ type: _angular_core.Output },],
    'onEnter': [{ type: _angular_core.Output },],
    'onEscape': [{ type: _angular_core.Output },],
    'onKeyPress': [{ type: _angular_core.Output },],
    'onFocus': [{ type: _angular_core.Output },],
    'onBlur': [{ type: _angular_core.Output },],
    'onClick': [{ type: _angular_core.Output },],
    'empty': [{ type: _angular_core.Input },],
    'checkedText': [{ type: _angular_core.Input },],
    'uncheckedText': [{ type: _angular_core.Input },],
    'saveOnEnter': [{ type: _angular_core.Input },],
    'saveOnBlur': [{ type: _angular_core.Input },],
    'saveOnChange': [{ type: _angular_core.Input },],
    'editOnClick': [{ type: _angular_core.Input },],
    'cancelOnEscape': [{ type: _angular_core.Input },],
    'hideButtons': [{ type: _angular_core.Input },],
    'disabled': [{ type: _angular_core.Input },],
    'required': [{ type: _angular_core.Input },],
    'onlyValue': [{ type: _angular_core.Input },],
    'placeholder': [{ type: _angular_core.Input },],
    'name': [{ type: _angular_core.Input },],
    'pattern': [{ type: _angular_core.Input },],
    'size': [{ type: _angular_core.Input },],
    'min': [{ type: _angular_core.Input },],
    'max': [{ type: _angular_core.Input },],
    'cols': [{ type: _angular_core.Input },],
    'rows': [{ type: _angular_core.Input },],
    'options': [{ type: _angular_core.Input },],
    'container': [{ type: _angular_core.ViewChild, args: ["container", { read: _angular_core.ViewContainerRef },] },],
};
var EXPORTS = [
    InputBase,
    InputTextComponent,
    InputNumberComponent,
    InputPasswordComponent,
    InputRangeComponent,
    InputTextareaComponent,
    InputSelectComponent,
    InputDateComponent,
    InputTimeComponent,
    InputDatetimeComponent,
    InputCheckboxComponent,
    InlineEditorComponent,
];
var InlineEditorModule = (function () {
    function InlineEditorModule() {
    }
    return InlineEditorModule;
}());
InlineEditorModule.decorators = [
    { type: _angular_core.NgModule, args: [{
                imports: [_angular_common.CommonModule, _angular_forms.FormsModule],
                declarations: EXPORTS,
                exports: [InlineEditorComponent],
            },] },
];
/**
 * @nocollapse
 */
InlineEditorModule.ctorParameters = function () { return []; };

exports.InlineEditorModule = InlineEditorModule;
exports.InlineEditorComponent = InlineEditorComponent;
exports.InputTextComponent = InputTextComponent;
exports.InputDateComponent = InputDateComponent;
exports.InputDatetimeComponent = InputDatetimeComponent;
exports.InputNumberComponent = InputNumberComponent;
exports.InputRangeComponent = InputRangeComponent;
exports.InputPasswordComponent = InputPasswordComponent;
exports.InputSelectComponent = InputSelectComponent;
exports.InputTextareaComponent = InputTextareaComponent;
exports.InputTimeComponent = InputTimeComponent;
exports.InputCheckboxComponent = InputCheckboxComponent;
exports.InputBase = InputBase;

Object.defineProperty(exports, '__esModule', { value: true });

})));
