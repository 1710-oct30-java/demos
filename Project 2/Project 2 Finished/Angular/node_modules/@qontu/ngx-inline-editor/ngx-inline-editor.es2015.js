import { ChangeDetectionStrategy, ChangeDetectorRef, Component, ComponentFactoryResolver, EventEmitter, Injector, Input, NgModule, Output, ReflectiveInjector, Renderer, ViewChild, ViewContainerRef, forwardRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, NG_VALIDATORS, NG_VALUE_ACCESSOR } from '@angular/forms';

class InlineEditorService {
    /**
     * @param {?} events
     * @param {?=} config
     */
    constructor(events, config) {
        this.events = events;
        this.config = config;
        this.onUpdateStateOfService = new EventEmitter();
        this.subscriptions = {};
        this.subscriptions.onUpdateStateSubscription = this.onUpdateStateOfService.subscribe((state) => this.state = state);
    }
    /**
     * @param {?} config
     * @return {?}
     */
    setConfig(config) {
        this.config = config;
    }
    /**
     * @return {?}
     */
    getConfig() {
        return this.config;
    }
    /**
     * @return {?}
     */
    getState() {
        return this.state.clone();
    }
    /**
     * @return {?}
     */
    destroy() {
        Object.values(this.subscriptions).forEach(subscription => subscription.unsubscribe());
    }
}

class InputBase {
    /**
     * @param {?} injector
     */
    constructor(injector) {
        this.injector = injector;
        this.isNumeric = false;
        this.isRegexTestable = false;
        this.isLengthTestable = false;
        this.subscriptions = {};
        this.renderer = injector.get(Renderer);
        this.service = injector.get(InlineEditorService);
        this.cd = injector.get(ChangeDetectorRef);
        this.onUpdateConfig(this.service.getConfig());
        this.state = this.service.getState().clone();
        this.subscriptions.onUpdateConfigSubcription = this.service.events.internal.onUpdateConfig.subscribe((config) => this.onUpdateConfig(config));
        this.subscriptions.onUpdateStateSubscription = this.service.events.internal.onUpdateStateOfChild.subscribe((state) => {
            const newState = state.getState();
            this.updateState(this.state.newState(Object.assign({}, newState, { empty: this.isEmpty(newState.value) })));
            this.service.events.internal.onUpdateStateOfParent.emit(this.state.clone());
        });
    }
    /**
     * @param {?} value
     * @return {?}
     */
    set value(value) {
        if (this.value === value) {
            return;
        }
        this.updateState(this.state.newState(Object.assign({}, this.state.getState(), { empty: this.isEmpty(value), value })));
        this.service.events.internal.onChange.emit({
            state: this.state.clone(),
        });
    }
    /**
     * @return {?}
     */
    get value() {
        return this.state.getState().value;
    }
    /**
     * @return {?}
     */
    ngOnChanges() { }
    /**
     * @return {?}
     */
    ngOnInit() {
        this.inputElement = this.inputRef.nativeElement;
    }
    /**
     * @return {?}
     */
    ngDoCheck() { }
    /**
     * @return {?}
     */
    ngAfterContentInit() { }
    /**
     * @return {?}
     */
    ngAfterContentChecked() { }
    /**
     * @return {?}
     */
    ngAfterViewInit() { }
    /**
     * @return {?}
     */
    ngAfterViewChecked() { }
    /**
     * @return {?}
     */
    ngOnDestroy() {
        Object.values(this.subscriptions).forEach(subscription => subscription.unsubscribe());
    }
    /**
     * @param {?} newConfig
     * @return {?}
     */
    onUpdateConfig(newConfig) {
        this.config = newConfig;
    }
    /**
     * @return {?}
     */
    save() {
        this.service.events.internal.onSave.emit({
            state: this.state.clone(),
        });
    }
    /**
     * @return {?}
     */
    cancel() {
        this.service.events.internal.onCancel.emit({
            state: this.state.clone(),
        });
    }
    /**
     * @param {?} event
     * @return {?}
     */
    onEnter(event) {
        this.service.events.internal.onEnter.emit({
            event,
            state: this.state.clone(),
        });
    }
    /**
     * @param {?} event
     * @return {?}
     */
    onEscape(event) {
        this.service.events.internal.onEscape.emit({
            event,
            state: this.state.clone(),
        });
    }
    /**
     * @param {?} event
     * @return {?}
     */
    onBlur(event) {
        this.service.events.internal.onBlur.emit({
            event,
            state: this.state.clone(),
        });
    }
    /**
     * @param {?} event
     * @return {?}
     */
    onClick(event) {
        this.service.events.internal.onClick.emit({
            event,
            state: this.state.clone(),
        });
    }
    /**
     * @param {?} event
     * @return {?}
     */
    onKeyPress(event) {
        this.service.events.internal.onKeyPress.emit({
            event,
            state: this.state.clone(),
        });
    }
    /**
     * @param {?} event
     * @return {?}
     */
    onFocus(event) {
        this.service.events.internal.onFocus.emit({
            event,
            state: this.state.clone(),
        });
    }
    /**
     * @return {?}
     */
    checkValue() {
        const /** @type {?} */ errs = [];
        const { value } = this.state.getState();
        if (this.canTestRegex(this.config)) {
            if (!new RegExp(/** @type {?} */ (this.config.pattern)).test(value != null && value !== false ? value : '')) {
                errs.push({
                    type: "PATTERN_ERROR",
                    message: "Test pattern has failed",
                });
            }
        }
        if (this.canTestLength(this.config)) {
            const { min, max } = this.config;
            const /** @type {?} */ length = value ? (this.isNumeric ? Number(value) : value.length) : 0;
            if (length < min || length > max) {
                errs.push({
                    type: "LENGTH_ERROR",
                    message: "Test length has failed",
                });
            }
        }
        return errs;
    }
    /**
     * @return {?}
     */
    showText() {
        return this.state.isEmpty() ? this.config.empty : this.state.getState().value;
    }
    /**
     * @return {?}
     */
    focus() {
        setTimeout(() => this.renderer.invokeElementMethod(this.inputElement, "focus", []));
    }
    /**
     * @return {?}
     */
    select() {
        setTimeout(() => this.renderer.invokeElementMethod(this.inputElement, "select", []));
    }
    /**
     * @param {?} newState
     * @return {?}
     */
    updateState(newState) {
        const { empty: wasEmpty, disabled: wasDisabled } = this.state.getState();
        if (newState.isEmpty() && newState.isEmpty() !== wasEmpty) {
            // onEmpty()
        }
        if (newState.isDisabled() && newState.isDisabled() !== wasDisabled) {
            // onDisabled()
        }
        this.state = newState;
        this.cd.markForCheck();
        this.service.onUpdateStateOfService.emit(this.state.clone());
    }
    /**
     * @param {?} value
     * @return {?}
     */
    isEmpty(value) {
        return value == null || value === "";
    }
    /**
     * @param {?} config
     * @return {?}
     */
    canTestRegex(config) {
        return this.isRegexTestable &&
            config.pattern != null &&
            (config.pattern instanceof RegExp || typeof config.pattern === "string");
    }
    /**
     * @param {?} config
     * @return {?}
     */
    canTestLength(config) {
        return (this.isNumeric || this.isLengthTestable) &&
            (config.min != null || config.max != null);
    }
}
InputBase.decorators = [
    { type: Component, args: [{
                template: " ",
                changeDetection: ChangeDetectionStrategy.OnPush,
            },] },
];
/**
 * @nocollapse
 */
InputBase.ctorParameters = () => [
    { type: Injector, },
];
InputBase.propDecorators = {
    'inputRef': [{ type: ViewChild, args: ["inputRef",] },],
};

class InputNumberComponent extends InputBase {
    /**
     * @param {?} injector
     */
    constructor(injector) {
        super(injector);
        this.isNumeric = true;
    }
}
InputNumberComponent.decorators = [
    { type: Component, args: [{
                selector: "inline-editor-number",
                styles: ["a {     text-decoration: none;     color: #428bca;     border-bottom: dashed 1px #428bca;     cursor: pointer;     line-height: 2;     margin-right: 5px;     margin-left: 5px; }   /* editable-empty */  .editable-empty, .editable-empty:hover, .editable-empty:focus, a.editable-empty, a.editable-empty:hover, a.editable-empty:focus {     font-style: italic;     color: #DD1144;     text-decoration: none; }  .inlineEditForm {     display: inline-block;     white-space: nowrap;     margin: 0; }  #inlineEditWrapper {     display: inline-block; }  .inlineEditForm input, select {     width: auto;     display: inline; }  .editInvalid {     color: #a94442;     margin-bottom: 0; }  .error {     border-color: #a94442; }  [hidden] {     display: none; }"],
                template: `<input #inputRef type="number" class="form-control" (keyup.enter)="onEnter($event)"
                (keyup.escape)="onEscape($event)" (focus)="onFocus($event)" (blur)="onBlur($event)" (blur)="onBlur($event)"
                (keypress)="onKeyPress($event)" [(ngModel)]="value" [required]="config.required"
                [disabled]="state.isDisabled()" [name]="config.name" [placeholder]="config.placeholder"
                [size]="config.size"/>`,
                changeDetection: ChangeDetectionStrategy.OnPush,
            },] },
];
/**
 * @nocollapse
 */
InputNumberComponent.ctorParameters = () => [
    { type: Injector, },
];

class InputTextComponent extends InputBase {
    /**
     * @param {?} injector
     */
    constructor(injector) {
        super(injector);
        this.isRegexTestable = true;
        this.isLengthTestable = true;
    }
}
InputTextComponent.decorators = [
    { type: Component, args: [{
                selector: "inline-editor-text",
                styles: ["a {     text-decoration: none;     color: #428bca;     border-bottom: dashed 1px #428bca;     cursor: pointer;     line-height: 2;     margin-right: 5px;     margin-left: 5px; }   /* editable-empty */  .editable-empty, .editable-empty:hover, .editable-empty:focus, a.editable-empty, a.editable-empty:hover, a.editable-empty:focus {     font-style: italic;     color: #DD1144;     text-decoration: none; }  .inlineEditForm {     display: inline-block;     white-space: nowrap;     margin: 0; }  #inlineEditWrapper {     display: inline-block; }  .inlineEditForm input, select {     width: auto;     display: inline; }  .editInvalid {     color: #a94442;     margin-bottom: 0; }  .error {     border-color: #a94442; }  [hidden] {     display: none; }"],
                template: `<input #inputRef type="text" (keyup.enter)="onEnter($event)" (keyup.escape)="onEscape($event)"
                (focus)="onFocus($event)" (blur)="onBlur($event)" (click)="onClick($event)" (keypress)="onKeyPress($event)"
                class="form-control" [(ngModel)]="value" [required]="config.required"
                [disabled]="state.isDisabled()" [name]="config.name" [placeholder]="config.placeholder"
                [size]="config.size"/>`,
                changeDetection: ChangeDetectionStrategy.OnPush,
            },] },
];
/**
 * @nocollapse
 */
InputTextComponent.ctorParameters = () => [
    { type: Injector, },
];

class InputPasswordComponent extends InputBase {
    /**
     * @param {?} injector
     */
    constructor(injector) {
        super(injector);
        this.isRegexTestable = true;
        this.isLengthTestable = true;
    }
    /**
     * @return {?}
     */
    showText() {
        const /** @type {?} */ isEmpty = this.state.isEmpty();
        const /** @type {?} */ value = String(this.state.getState().value);
        return isEmpty ?
            this.config.empty :
            "*".repeat(value.length);
    }
}
InputPasswordComponent.decorators = [
    { type: Component, args: [{
                selector: "inline-editor-password",
                styles: ["a {     text-decoration: none;     color: #428bca;     border-bottom: dashed 1px #428bca;     cursor: pointer;     line-height: 2;     margin-right: 5px;     margin-left: 5px; }   /* editable-empty */  .editable-empty, .editable-empty:hover, .editable-empty:focus, a.editable-empty, a.editable-empty:hover, a.editable-empty:focus {     font-style: italic;     color: #DD1144;     text-decoration: none; }  .inlineEditForm {     display: inline-block;     white-space: nowrap;     margin: 0; }  #inlineEditWrapper {     display: inline-block; }  .inlineEditForm input, select {     width: auto;     display: inline; }  .editInvalid {     color: #a94442;     margin-bottom: 0; }  .error {     border-color: #a94442; }  [hidden] {     display: none; }"],
                template: `<input #inputRef type="password" class="form-control" (keyup.enter)="onEnter($event)"
                (keyup.escape)="onEscape($event)" (focus)="onFocus($event)" (blur)="onBlur($event)" (click)="onClick($event)"
                (keypress)="onKeyPress($event)" [(ngModel)]="value" [required]="config.required"
                [disabled]="state.isDisabled()" [name]="config.name" [placeholder]="config.placeholder"
                [size]="config.size"/>`,
                changeDetection: ChangeDetectionStrategy.OnPush,
            },] },
];
/**
 * @nocollapse
 */
InputPasswordComponent.ctorParameters = () => [
    { type: Injector, },
];

class InputRangeComponent extends InputBase {
    /**
     * @param {?} injector
     */
    constructor(injector) {
        super(injector);
        this.isNumeric = true;
    }
}
InputRangeComponent.decorators = [
    { type: Component, args: [{
                selector: "inline-editor-range",
                styles: ["a {     text-decoration: none;     color: #428bca;     border-bottom: dashed 1px #428bca;     cursor: pointer;     line-height: 2;     margin-right: 5px;     margin-left: 5px; }   /* editable-empty */  .editable-empty, .editable-empty:hover, .editable-empty:focus, a.editable-empty, a.editable-empty:hover, a.editable-empty:focus {     font-style: italic;     color: #DD1144;     text-decoration: none; }  .inlineEditForm {     display: inline-block;     white-space: nowrap;     margin: 0; }  #inlineEditWrapper {     display: inline-block; }  .inlineEditForm input, select {     width: auto;     display: inline; }  .editInvalid {     color: #a94442;     margin-bottom: 0; }  .error {     border-color: #a94442; }  [hidden] {     display: none; }"],
                template: `<input #inputRef type="range" class="form-control" (keyup.enter)="onEnter($event)"
                (keyup.escape)="onEscape($event)" (focus)="onFocus($event)" (blur)="onBlur($event)" (click)="onClick($event)"
                (keypress)="onKeyPress($event)" [(ngModel)]="value" [required]="config.required"
                [disabled]="state.isDisabled()" [name]="config.name" [placeholder]="config.placeholder"
                [min]="config.min" [max]="config.max"/>`,
                changeDetection: ChangeDetectionStrategy.OnPush,
            },] },
];
/**
 * @nocollapse
 */
InputRangeComponent.ctorParameters = () => [
    { type: Injector, },
];

class InputCheckboxComponent extends InputBase {
    /**
     * @param {?} injector
     */
    constructor(injector) {
        super(injector);
    }
    /**
     * @return {?}
     */
    showText() {
        return this.value ? this.config.checkedText : this.config.uncheckedText;
    }
}
InputCheckboxComponent.decorators = [
    { type: Component, args: [{
                selector: "inline-editor-checkbox",
                styles: ["a {     text-decoration: none;     color: #428bca;     border-bottom: dashed 1px #428bca;     cursor: pointer;     line-height: 2;     margin-right: 5px;     margin-left: 5px; }   /* editable-empty */  .editable-empty, .editable-empty:hover, .editable-empty:focus, a.editable-empty, a.editable-empty:hover, a.editable-empty:focus {     font-style: italic;     color: #DD1144;     text-decoration: none; }  .inlineEditForm {     display: inline-block;     white-space: nowrap;     margin: 0; }  #inlineEditWrapper {     display: inline-block; }  .inlineEditForm input, select {     width: auto;     display: inline; }  .editInvalid {     color: #a94442;     margin-bottom: 0; }  .error {     border-color: #a94442; }  [hidden] {     display: none; }"],
                template: `<input #inputRef type="checkbox" class="form-control" (focus)="onFocus($event)" (blur)="onBlur($event)"
                (keypress)="onKeyPress($event)" [(ngModel)]="value" [required]="config.required"
                [disabled]="state.isDisabled()" [name]="config.name"/>`,
                changeDetection: ChangeDetectionStrategy.OnPush,
            },] },
];
/**
 * @nocollapse
 */
InputCheckboxComponent.ctorParameters = () => [
    { type: Injector, },
];

class InputTextareaComponent extends InputBase {
    /**
     * @param {?} injector
     */
    constructor(injector) {
        super(injector);
        this.isRegexTestable = true;
        this.isLengthTestable = true;
    }
}
InputTextareaComponent.decorators = [
    { type: Component, args: [{
                selector: "inline-editor-textarea",
                styles: ["a {     text-decoration: none;     color: #428bca;     border-bottom: dashed 1px #428bca;     cursor: pointer;     line-height: 2;     margin-right: 5px;     margin-left: 5px; }   /* editable-empty */  .editable-empty, .editable-empty:hover, .editable-empty:focus, a.editable-empty, a.editable-empty:hover, a.editable-empty:focus {     font-style: italic;     color: #DD1144;     text-decoration: none; }  .inlineEditForm {     display: inline-block;     white-space: nowrap;     margin: 0; }  #inlineEditWrapper {     display: inline-block; }  .inlineEditForm input, select {     width: auto;     display: inline; }  .editInvalid {     color: #a94442;     margin-bottom: 0; }  .error {     border-color: #a94442; }  [hidden] {     display: none; }"],
                template: `<textarea #inputRef class="form-control" (keyup.enter)="onEnter($event)"
                (keyup.escape)="onEscape($event)" (focus)="onFocus($event)" (blur)="onBlur($event)" (click)="onClick($event)"
                (keypress)="onKeyPress($event)" [(ngModel)]="value" [required]="config.required"
                [rows]="config.rows" [cols]="config.cols" [disabled]="state.isDisabled()" [name]="config.name"
                [placeholder]="config.placeholder"></textarea>`,
                changeDetection: ChangeDetectionStrategy.OnPush,
            },] },
];
/**
 * @nocollapse
 */
InputTextareaComponent.ctorParameters = () => [
    { type: Injector, },
];

class InputSelectComponent extends InputBase {
    /**
     * @param {?} injector
     */
    constructor(injector) {
        super(injector);
        this.subscriptions.onUpdateConfigSubcription.unsubscribe();
        this.subscriptions.onUpdateConfigSubcription = this.service.events.internal.onUpdateConfig.subscribe((config) => this.onUpdateConfig(config));
    }
    /**
     * @param {?} config
     * @return {?}
     */
    onUpdateConfig(config) {
        super.onUpdateConfig(config);
        const { options } = this.config;
        this.config.options = options instanceof Array ?
            {
                data: options,
                value: "value",
                text: "text",
            } : options;
        this.config = Object.assign({}, this.config);
    }
    /**
     * @return {?}
     */
    showText() {
        const { text: keyOfText, value: keyOfValue, data: options } = this.config.options;
        const /** @type {?} */ currentValue = this.state.getState().value;
        const /** @type {?} */ optionSelected = this.getOptionSelected(currentValue, keyOfValue, options);
        return optionSelected ? optionSelected[keyOfText] : this.config.empty;
    }
    /**
     * @param {?} currentValue
     * @param {?} keyOfValue
     * @param {?} options
     * @return {?}
     */
    getOptionSelected(currentValue, keyOfValue, options) {
        let /** @type {?} */ optionSelected;
        for (const /** @type {?} */ option of options) {
            if (this.isAnOptionWithChildren(option)) {
                optionSelected = this.getOptionSelected(currentValue, keyOfValue, /** @type {?} */ ((option.children)));
            }
            else {
                const /** @type {?} */ typeOfValue = typeof option[keyOfValue];
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
    }
    /**
     * @param {?} value
     * @return {?}
     */
    isEmpty(value) {
        const { value: keyOfValue, data: options } = this.config.options;
        return this.getOptionSelected(value, keyOfValue, options) == null;
    }
    /**
     * @param {?} options
     * @return {?}
     */
    isAnOptionWithChildren(options) {
        return options.children != null && options.children instanceof Array;
    }
}
InputSelectComponent.decorators = [
    { type: Component, args: [{
                selector: "inline-editor-select",
                styles: ["a {     text-decoration: none;     color: #428bca;     border-bottom: dashed 1px #428bca;     cursor: pointer;     line-height: 2;     margin-right: 5px;     margin-left: 5px; }   /* editable-empty */  .editable-empty, .editable-empty:hover, .editable-empty:focus, a.editable-empty, a.editable-empty:hover, a.editable-empty:focus {     font-style: italic;     color: #DD1144;     text-decoration: none; }  .inlineEditForm {     display: inline-block;     white-space: nowrap;     margin: 0; }  #inlineEditWrapper {     display: inline-block; }  .inlineEditForm input, select {     width: auto;     display: inline; }  .editInvalid {     color: #a94442;     margin-bottom: 0; }  .error {     border-color: #a94442; }  [hidden] {     display: none; }"],
                template: `
    <select #inputRef class="form-control" [(ngModel)]="value"
    (focus)="onFocus($event)" (keypress)="onKeyPress($event)" (blur)="onBlur($event)" (click)="onClick($event)"
    (keypress.enter)="onEnter($event)" (keypress.escape)="onEscape($event)" [disabled]="state.isDisabled()">
        <ng-template ngFor let-option [ngForOf]="config.options.data">
            <optgroup *ngIf="option.children" [label]="option[config.options.text]">
                <option *ngFor="let child of option.children" [ngValue]="child[config.options.value]">
                    {{child[config.options.text]}}
                </option>
            </optgroup>
            <option *ngIf="!option.children" [ngValue]="option[config.options.value]">
                {{option[config.options.text]}}
            </option>
        </ng-template>
    </select>
            `,
                changeDetection: ChangeDetectionStrategy.OnPush,
            },] },
];
/**
 * @nocollapse
 */
InputSelectComponent.ctorParameters = () => [
    { type: Injector, },
];

class InputDateComponent extends InputBase {
    /**
     * @param {?} injector
     */
    constructor(injector) {
        super(injector);
        this.isRegexTestable = true;
    }
}
InputDateComponent.decorators = [
    { type: Component, args: [{
                selector: "inline-editor-date",
                styles: ["a {     text-decoration: none;     color: #428bca;     border-bottom: dashed 1px #428bca;     cursor: pointer;     line-height: 2;     margin-right: 5px;     margin-left: 5px; }   /* editable-empty */  .editable-empty, .editable-empty:hover, .editable-empty:focus, a.editable-empty, a.editable-empty:hover, a.editable-empty:focus {     font-style: italic;     color: #DD1144;     text-decoration: none; }  .inlineEditForm {     display: inline-block;     white-space: nowrap;     margin: 0; }  #inlineEditWrapper {     display: inline-block; }  .inlineEditForm input, select {     width: auto;     display: inline; }  .editInvalid {     color: #a94442;     margin-bottom: 0; }  .error {     border-color: #a94442; }  [hidden] {     display: none; }"],
                template: `<input #inputRef type="date" class="form-control" (keyup.enter)="onEnter($event)"
                (keyup.escape)="onEscape($event)" (focus)="onFocus($event)" (blur)="onBlur($event)" (blur)="onBlur($event)"
                (keypress)="onKeyPress($event)" [(ngModel)]="value" [required]="config.required"
                [disabled]="state.isDisabled()" [name]="config.name" [placeholder]="config.placeholder"
                [size]="config.size" [min]="config.min" [max]="config.max"/>`,
                changeDetection: ChangeDetectionStrategy.OnPush,
            },] },
];
/**
 * @nocollapse
 */
InputDateComponent.ctorParameters = () => [
    { type: Injector, },
];

class InputTimeComponent extends InputBase {
    /**
     * @param {?} injector
     */
    constructor(injector) {
        super(injector);
        this.isRegexTestable = true;
    }
}
InputTimeComponent.decorators = [
    { type: Component, args: [{
                selector: "inline-editor-time",
                styles: ["a {     text-decoration: none;     color: #428bca;     border-bottom: dashed 1px #428bca;     cursor: pointer;     line-height: 2;     margin-right: 5px;     margin-left: 5px; }   /* editable-empty */  .editable-empty, .editable-empty:hover, .editable-empty:focus, a.editable-empty, a.editable-empty:hover, a.editable-empty:focus {     font-style: italic;     color: #DD1144;     text-decoration: none; }  .inlineEditForm {     display: inline-block;     white-space: nowrap;     margin: 0; }  #inlineEditWrapper {     display: inline-block; }  .inlineEditForm input, select {     width: auto;     display: inline; }  .editInvalid {     color: #a94442;     margin-bottom: 0; }  .error {     border-color: #a94442; }  [hidden] {     display: none; }"],
                template: `<input #inputRef type="time" class="form-control" (keyup.enter)="onEnter($event)"
                (keyup.escape)="onEscape($event)" (focus)="onFocus($event)" (blur)="onBlur($event)" (click)="onClick($event)"
                (keypress)="onKeyPress($event)" [(ngModel)]="value" [required]="config.required"
                [disabled]="config.disabled" [name]="config.name" [placeholder]="config.placeholder"
                [size]="config.size" [min]="config.min" [max]="config.max"/>`,
                changeDetection: ChangeDetectionStrategy.OnPush,
            },] },
];
/**
 * @nocollapse
 */
InputTimeComponent.ctorParameters = () => [
    { type: Injector, },
];

class InputDatetimeComponent extends InputBase {
    /**
     * @param {?} injector
     */
    constructor(injector) {
        super(injector);
        this.isRegexTestable = true;
    }
}
InputDatetimeComponent.decorators = [
    { type: Component, args: [{
                selector: "inline-editor-datetime",
                styles: ["a {     text-decoration: none;     color: #428bca;     border-bottom: dashed 1px #428bca;     cursor: pointer;     line-height: 2;     margin-right: 5px;     margin-left: 5px; }   /* editable-empty */  .editable-empty, .editable-empty:hover, .editable-empty:focus, a.editable-empty, a.editable-empty:hover, a.editable-empty:focus {     font-style: italic;     color: #DD1144;     text-decoration: none; }  .inlineEditForm {     display: inline-block;     white-space: nowrap;     margin: 0; }  #inlineEditWrapper {     display: inline-block; }  .inlineEditForm input, select {     width: auto;     display: inline; }  .editInvalid {     color: #a94442;     margin-bottom: 0; }  .error {     border-color: #a94442; }  [hidden] {     display: none; }"],
                template: `<input #inputRef type="datetime-local" class="form-control" (keyup.enter)="onEnter($event)"
                (keyup.escape)="onEscape($event)" (focus)="onFocus($event)" (blur)="onBlur($event)" (blur)="onBlur($event)"
                (keypress)="onKeyPress($event)" [(ngModel)]="value" [required]="config.required"
                [disabled]="state.isDisabled()" [name]="config.name" [placeholder]="config.placeholder"
                [size]="config.size" [min]="config.min" [max]="config.max"/>`,
                changeDetection: ChangeDetectionStrategy.OnPush,
            },] },
];
/**
 * @nocollapse
 */
InputDatetimeComponent.ctorParameters = () => [
    { type: Injector, },
];

class InternalEvents {
    constructor() {
        this.onUpdateStateOfParent = new EventEmitter();
        this.onUpdateStateOfChild = new EventEmitter();
        this.onChange = new EventEmitter();
        this.onFocus = new EventEmitter();
        this.onBlur = new EventEmitter();
        this.onKeyPress = new EventEmitter();
        this.onEnter = new EventEmitter();
        this.onEscape = new EventEmitter();
        this.onSave = new EventEmitter();
        this.onEdit = new EventEmitter();
        this.onCancel = new EventEmitter();
        this.onClick = new EventEmitter();
        this.onUpdateConfig = new EventEmitter();
    }
}
class ExternalEvents {
    constructor() {
        this.onChange = new EventEmitter();
        this.onSave = new EventEmitter();
        this.onKeyPress = new EventEmitter();
        this.onFocus = new EventEmitter();
        this.onBlur = new EventEmitter();
        this.onEnter = new EventEmitter();
        this.onEscape = new EventEmitter();
        this.onEdit = new EventEmitter();
        this.onCancel = new EventEmitter();
        this.onClick = new EventEmitter();
        this.onError = new EventEmitter();
    }
}

class InlineEditorState {
    /**
     * @param {?=} __0
     */
    constructor({ value, disabled = false, editing = false, empty = false, } = { value: "" }) {
        this.value = value;
        this.disabled = disabled;
        this.editing = editing;
        this.empty = empty;
    }
    /**
     * @param {?} state
     * @return {?}
     */
    newState(state) {
        return new InlineEditorState(state instanceof InlineEditorState ?
            state.getState() : state);
    }
    /**
     * @return {?}
     */
    getState() {
        const { value, editing, disabled, empty } = this;
        return {
            value,
            editing,
            disabled,
            empty,
        };
    }
    /**
     * @return {?}
     */
    clone() {
        return this.newState(this);
    }
    /**
     * @return {?}
     */
    isEmpty() {
        return this.empty;
    }
    /**
     * @return {?}
     */
    isEditing() {
        return this.editing;
    }
    /**
     * @return {?}
     */
    isDisabled() {
        return this.disabled;
    }
}

const defaultConfig = {
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
class InlineEditorComponent {
    /**
     * @param {?} componentFactoryResolver
     */
    constructor(componentFactoryResolver) {
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
    /**
     * @param {?} empty
     * @return {?}
     */
    set empty(empty) {
        this._empty = empty;
        this.updateConfig(undefined, "empty", empty);
    }
    /**
     * @return {?}
     */
    get empty() {
        return this._empty;
    }
    /**
     * @param {?} checkedText
     * @return {?}
     */
    set checkedText(checkedText) {
        this._checkedText = checkedText;
        this.updateConfig(undefined, "checkedText", checkedText);
    }
    /**
     * @return {?}
     */
    get checkedText() {
        return this._checkedText;
    }
    /**
     * @param {?} uncheckedText
     * @return {?}
     */
    set uncheckedText(uncheckedText) {
        this._uncheckedText = uncheckedText;
        this.updateConfig(undefined, "uncheckedText", uncheckedText);
    }
    /**
     * @return {?}
     */
    get uncheckedText() {
        return this._uncheckedText;
    }
    /**
     * @param {?} saveOnEnter
     * @return {?}
     */
    set saveOnEnter(saveOnEnter) {
        this._saveOnEnter = saveOnEnter;
        this.updateConfig(undefined, "saveOnEnter", saveOnEnter);
    }
    /**
     * @return {?}
     */
    get saveOnEnter() {
        return this._saveOnEnter;
    }
    /**
     * @param {?} saveOnBlur
     * @return {?}
     */
    set saveOnBlur(saveOnBlur) {
        this._saveOnBlur = saveOnBlur;
        this.updateConfig(undefined, "saveOnBlur", saveOnBlur);
    }
    /**
     * @return {?}
     */
    get saveOnBlur() {
        return this._saveOnBlur;
    }
    /**
     * @param {?} saveOnChange
     * @return {?}
     */
    set saveOnChange(saveOnChange) {
        this._saveOnChange = saveOnChange;
        this.updateConfig(undefined, "saveOnChange", saveOnChange);
    }
    /**
     * @return {?}
     */
    get saveOnChange() {
        return this._saveOnChange;
    }
    /**
     * @param {?} editOnClick
     * @return {?}
     */
    set editOnClick(editOnClick) {
        this._editOnClick = editOnClick;
        this.updateConfig(undefined, "editOnClick", editOnClick);
    }
    /**
     * @return {?}
     */
    get editOnClick() {
        return this._editOnClick;
    }
    /**
     * @param {?} cancelOnEscape
     * @return {?}
     */
    set cancelOnEscape(cancelOnEscape) {
        this._cancelOnEscape = cancelOnEscape;
        this.updateConfig(undefined, "cancelOnEscape", cancelOnEscape);
    }
    /**
     * @return {?}
     */
    get cancelOnEscape() {
        return this._cancelOnEscape;
    }
    /**
     * @param {?} hideButtons
     * @return {?}
     */
    set hideButtons(hideButtons) {
        this._hideButtons = hideButtons;
        this.updateConfig(undefined, "hideButtons", hideButtons);
    }
    /**
     * @return {?}
     */
    get hideButtons() {
        return this._hideButtons;
    }
    /**
     * @param {?} disabled
     * @return {?}
     */
    set disabled(disabled) {
        this._disabled = disabled;
        this.updateConfig(undefined, "disabled", disabled);
    }
    /**
     * @return {?}
     */
    get disabled() {
        return this._disabled;
    }
    /**
     * @param {?} required
     * @return {?}
     */
    set required(required) {
        this._required = required;
        this.updateConfig(undefined, "required", required);
    }
    /**
     * @return {?}
     */
    get required() {
        return this._required;
    }
    /**
     * @param {?} onlyValue
     * @return {?}
     */
    set onlyValue(onlyValue) {
        this._onlyValue = onlyValue;
        this.updateConfig(undefined, "onlyValue", onlyValue);
    }
    /**
     * @return {?}
     */
    get onlyValue() {
        return this._onlyValue;
    }
    /**
     * @param {?} placeholder
     * @return {?}
     */
    set placeholder(placeholder) {
        this._placeholder = placeholder;
        this.updateConfig(undefined, "placeholder", placeholder);
    }
    /**
     * @return {?}
     */
    get placeholder() {
        return this._placeholder;
    }
    /**
     * @param {?} name
     * @return {?}
     */
    set name(name) {
        this._name = name;
        this.updateConfig(undefined, "name", name);
    }
    /**
     * @return {?}
     */
    get name() {
        return this._name;
    }
    /**
     * @param {?} pattern
     * @return {?}
     */
    set pattern(pattern) {
        this._pattern = pattern;
        this.updateConfig(undefined, "pattern", pattern);
    }
    /**
     * @return {?}
     */
    get pattern() {
        return this._pattern;
    }
    /**
     * @param {?} size
     * @return {?}
     */
    set size(size) {
        this._size = size;
        this.updateConfig(undefined, "size", size);
    }
    /**
     * @return {?}
     */
    get size() {
        return this._size;
    }
    /**
     * @param {?} min
     * @return {?}
     */
    set min(min) {
        this._min = min;
        this.updateConfig(undefined, "min", min);
    }
    /**
     * @return {?}
     */
    get min() {
        return this._min;
    }
    /**
     * @param {?} max
     * @return {?}
     */
    set max(max) {
        this._max = max;
        this.updateConfig(undefined, "max", max);
    }
    /**
     * @return {?}
     */
    get max() {
        return this._max;
    }
    /**
     * @param {?} cols
     * @return {?}
     */
    set cols(cols) {
        this._cols = cols;
        this.updateConfig(undefined, "cols", cols);
    }
    /**
     * @return {?}
     */
    get cols() {
        return this._cols;
    }
    /**
     * @param {?} rows
     * @return {?}
     */
    set rows(rows) {
        this._rows = rows;
        this.updateConfig(undefined, "rows", rows);
    }
    /**
     * @return {?}
     */
    get rows() {
        return this._rows;
    }
    /**
     * @param {?} options
     * @return {?}
     */
    set options(options) {
        this._options = options;
        this.updateConfig(undefined, "options", options);
    }
    /**
     * @return {?}
     */
    get options() {
        return this._options;
    }
    /**
     * @return {?}
     */
    ngOnInit() {
        this.config = this.generateSafeConfig();
        this.state = new InlineEditorState({
            disabled: this.config.disabled,
            value: "",
        });
        this.service = new InlineEditorService(this.events, Object.assign({}, this.config));
        this.subscriptions.onUpdateStateSubcription = this.events.internal.onUpdateStateOfParent.subscribe((state) => this.state = state);
        this.subscriptions.onSaveSubscription = this.events.internal.onSave.subscribe(({ event, state }) => this.save({
            event,
            state: state.getState(),
        }));
        this.subscriptions.onCancelSubscription = this.events.internal.onCancel.subscribe(({ event, state }) => this.cancel({
            event,
            state: state.getState(),
        }));
        this.subscriptions.onChangeSubcription = this.events.internal.onChange.subscribe(({ event, state }) => {
            if (this.config.saveOnChange) {
                this.saveAndClose({
                    event,
                    state: state.getState(),
                });
            }
            this.emit(this.onChange, {
                event,
                state: state.getState(),
            });
        });
        this.subscriptions.onKeyPressSubcription = this.events.internal.onKeyPress.subscribe(({ event, state }) => this.emit(this.onKeyPress, {
            event,
            state: state.getState(),
        }));
        this.subscriptions.onBlurSubscription = this.events.internal.onBlur.subscribe(({ event, state }) => {
            // TODO (xxxtonixx): Maybe, this approach is not the best,
            // because we need to set a class property and it is dangerous.
            // We should search for one better.
            const /** @type {?} */ isSavedByEnterKey = this.isEnterKeyPressed && this.config.saveOnEnter;
            if (this.config.saveOnBlur && !isSavedByEnterKey) {
                this.saveAndClose({
                    event,
                    state: state.getState(),
                });
            }
            this.isEnterKeyPressed = false;
            this.emit(this.onBlur, {
                event,
                state: state.getState(),
            });
        });
        this.subscriptions.onClickSubcription = this.events.internal.onClick.subscribe(({ event, state }) => this.emit(this.onClick, {
            event,
            state: state.getState(),
        }));
        this.subscriptions.onFocusSubcription = this.events.internal.onFocus.subscribe(({ event, state }) => this.emit(this.onFocus, {
            event,
            state: state.getState(),
        }));
        this.subscriptions.onEnterSubscription = this.events.internal.onEnter.subscribe(({ event, state }) => {
            this.isEnterKeyPressed = true;
            if (this.config.saveOnEnter) {
                this.save({
                    event,
                    state: state.getState(),
                });
                this.edit({ editing: false });
            }
            this.emit(this.onEnter, {
                event,
                state: state.getState(),
            });
        });
        this.subscriptions.onEscapeSubscription = this.events.internal.onEscape.subscribe(({ event, state }) => {
            if (this.config.cancelOnEscape) {
                this.cancel({
                    event,
                    state: state.getState(),
                });
            }
            this.emit(this.onEscape, {
                event,
                state: state.getState(),
            });
        });
    }
    /**
     * @return {?}
     */
    ngAfterContentInit() {
        this.service.onUpdateStateOfService.emit(this.state.clone());
        this.generateComponent(this.config.type);
    }
    /**
     * @return {?}
     */
    ngOnDestroy() {
        Object.values(this.subscriptions).forEach(subscription => subscription.unsubscribe());
        this.currentComponent.destroy();
        this.service.destroy();
    }
    /**
     * @return {?}
     */
    validate() {
        const /** @type {?} */ errors = this.inputInstance ? this.inputInstance.checkValue() : [];
        return errors.length === 0 ? null : {
            InlineEditorError: {
                valid: false,
            },
        };
    }
    /**
     * @param {?} value
     * @return {?}
     */
    writeValue(value) {
        this.state = this.state.newState(Object.assign({}, this.state.getState(), { value }));
        this.events.internal.onUpdateStateOfChild.emit(this.state.clone());
    }
    /**
     * @param {?} refreshNGModel
     * @return {?}
     */
    registerOnChange(refreshNGModel) {
        this.refreshNGModel = refreshNGModel;
    }
    /**
     * @return {?}
     */
    registerOnTouched() { }
    /**
     * @param {?=} __0
     * @return {?}
     */
    edit({ editing = true, focus = true, select = false, event } = {}) {
        this.state = this.state.newState(Object.assign({}, this.state.getState(), { editing }));
        this.events.internal.onUpdateStateOfChild.emit(this.state.clone());
        if (editing) {
            this.emit(this.onEdit, {
                event,
                state: this.state.getState(),
            });
        }
        if (editing && focus) {
            this.inputInstance.focus();
        }
        if (editing && select) {
            this.inputInstance.select();
        }
    }
    /**
     * @param {?} __0
     * @return {?}
     */
    save({ event, state: hotState }) {
        const /** @type {?} */ prevState = this.state.getState();
        const /** @type {?} */ state = Object.assign({}, prevState, hotState);
        const /** @type {?} */ errors = this.inputInstance.checkValue();
        if (errors.length !== 0) {
            this.onError.emit(errors);
        }
        else {
            this.state = this.state.newState(state);
            this.refreshNGModel(state.value);
            this.emit(this.onSave, {
                event,
                state,
            });
        }
    }
    /**
     * @param {?} outsideEvent
     * @return {?}
     */
    saveAndClose(outsideEvent) {
        this.save(outsideEvent);
        this.edit({ editing: false });
    }
    /**
     * @param {?} outsideEvent
     * @return {?}
     */
    cancel(outsideEvent) {
        this.edit({ editing: false });
        this.emit(this.onCancel, outsideEvent);
    }
    /**
     * @return {?}
     */
    getHotState() {
        return this.inputInstance.state.getState();
    }
    /**
     * @return {?}
     */
    showText() {
        return this.inputInstance ? this.inputInstance.showText() : "Loading...";
    }
    /**
     * @param {?} typeName
     * @return {?}
     */
    getComponentType(typeName) {
        const /** @type {?} */ type = this.components[typeName];
        if (!type) {
            throw new Error("That type does not exist or it is not implemented yet!");
        }
        return type;
    }
    /**
     * @param {?} type
     * @return {?}
     */
    generateComponent(type) {
        const /** @type {?} */ componentType = this.getComponentType(type);
        this.inputInstance = this.createInputInstance(componentType);
    }
    /**
     * @param {?} componentType
     * @return {?}
     */
    createInputInstance(componentType) {
        const /** @type {?} */ providers = ReflectiveInjector.resolve([{
                provide: InlineEditorService,
                useValue: this.service,
            }]);
        const /** @type {?} */ injector = ReflectiveInjector.fromResolvedProviders(providers, this.container.parentInjector);
        const /** @type {?} */ factory = this.componentFactoryResolver.resolveComponentFactory(componentType);
        this.componentRef = factory.create(injector);
        this.container.insert(this.componentRef.hostView);
        if (this.currentComponent) {
            this.currentComponent.destroy();
        }
        this.currentComponent = this.componentRef;
        return (this.componentRef.instance);
    }
    /**
     * @template T
     * @param {?} object
     * @return {?}
     */
    removeUndefinedProperties(object) {
        return JSON.parse(JSON.stringify(typeof object === "object" ? object : {}));
    }
    /**
     * @return {?}
     */
    generateSafeConfig() {
        const /** @type {?} */ configFromAttrs = {
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
    }
    /**
     * @param {?=} config
     * @param {?=} property
     * @param {?=} value
     * @return {?}
     */
    updateConfig(config, property, value) {
        if (this.config) {
            config = config || this.config;
            if (property) {
                config[property] = value;
            }
            this.config = Object.assign({}, config);
            this.events.internal.onUpdateConfig.emit(this.config);
        }
    }
    /**
     * @param {?} event
     * @param {?} data
     * @return {?}
     */
    emit(event, data) {
        if (this.config.onlyValue) {
            event.emit(data.state.value);
        }
        else {
            ((event))
                .emit(Object.assign({}, data, { instance: this }));
        }
    }
}
InlineEditorComponent.decorators = [
    { type: Component, args: [{
                selector: "inline-editor",
                template: "<div id=\"inlineEditWrapper\">   <a [ngClass]=\"{'editable-empty': state.isEmpty(), 'c-inline-editor': true }\" (click)=\"!config.editOnClick || edit()\" [hidden]=\"state.isEditing() && !config.disabled\">{{ showText() }}</a>   <div class=\"c-inline-editor inlineEditForm form-inline\" [hidden]=\"!state.isEditing() || config.disabled\">     <div class=\"form-group\">       <div #container></div>       <span *ngIf=\"!config.hideButtons\" class=\"c-inline-editor inline-editor-button-group\">       <button id=\"inline-editor-button-save\" class=\"btn btn-xs btn-primary c-inline-editor\"           (click)=\"saveAndClose({ event: $event, state: service.getState() })\">           <span class=\"fa fa-check\"></span>       </button>       <button class=\"btn btn-xs btn-danger c-inline-editor\" (click)=\"cancel({ event: $event, state: service.getState() })\"><span class=\"fa fa-remove\"></span> </button>       </span>      </div>   </div> </div>",
                providers: [
                    {
                        provide: NG_VALUE_ACCESSOR,
                        useExisting: forwardRef(() => InlineEditorComponent),
                        multi: true,
                    },
                    {
                        provide: NG_VALIDATORS,
                        useExisting: forwardRef(() => InlineEditorComponent),
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
                changeDetection: ChangeDetectionStrategy.OnPush,
            },] },
];
/**
 * @nocollapse
 */
InlineEditorComponent.ctorParameters = () => [
    { type: ComponentFactoryResolver, },
];
InlineEditorComponent.propDecorators = {
    'type': [{ type: Input },],
    'config': [{ type: Input },],
    'onChange': [{ type: Output },],
    'onSave': [{ type: Output },],
    'onEdit': [{ type: Output },],
    'onCancel': [{ type: Output },],
    'onError': [{ type: Output },],
    'onEnter': [{ type: Output },],
    'onEscape': [{ type: Output },],
    'onKeyPress': [{ type: Output },],
    'onFocus': [{ type: Output },],
    'onBlur': [{ type: Output },],
    'onClick': [{ type: Output },],
    'empty': [{ type: Input },],
    'checkedText': [{ type: Input },],
    'uncheckedText': [{ type: Input },],
    'saveOnEnter': [{ type: Input },],
    'saveOnBlur': [{ type: Input },],
    'saveOnChange': [{ type: Input },],
    'editOnClick': [{ type: Input },],
    'cancelOnEscape': [{ type: Input },],
    'hideButtons': [{ type: Input },],
    'disabled': [{ type: Input },],
    'required': [{ type: Input },],
    'onlyValue': [{ type: Input },],
    'placeholder': [{ type: Input },],
    'name': [{ type: Input },],
    'pattern': [{ type: Input },],
    'size': [{ type: Input },],
    'min': [{ type: Input },],
    'max': [{ type: Input },],
    'cols': [{ type: Input },],
    'rows': [{ type: Input },],
    'options': [{ type: Input },],
    'container': [{ type: ViewChild, args: ["container", { read: ViewContainerRef },] },],
};

const EXPORTS = [
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
class InlineEditorModule {
}
InlineEditorModule.decorators = [
    { type: NgModule, args: [{
                imports: [CommonModule, FormsModule],
                declarations: EXPORTS,
                exports: [InlineEditorComponent],
            },] },
];
/**
 * @nocollapse
 */
InlineEditorModule.ctorParameters = () => [];

export { InlineEditorModule, InlineEditorComponent, InputTextComponent, InputDateComponent, InputDatetimeComponent, InputNumberComponent, InputRangeComponent, InputPasswordComponent, InputSelectComponent, InputTextareaComponent, InputTimeComponent, InputCheckboxComponent, InputBase };
