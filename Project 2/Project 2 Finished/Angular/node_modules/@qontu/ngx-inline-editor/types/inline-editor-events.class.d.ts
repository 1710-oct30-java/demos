import { EventEmitter } from "@angular/core";
import { InlineEditorError } from "./inline-editor-error.interface";
import { InlineConfig } from "../types/inline-configs";
import { InlineEditorState, InlineEditorStateOptions } from "./inline-editor-state.class";
import { InlineEditorComponent } from "../inline-editor.component";
export interface Events {
    internal: InternalEvents;
    external: ExternalEvents;
}
export declare class InternalEvents {
    onUpdateStateOfParent: EventEmitter<InlineEditorState>;
    onUpdateStateOfChild: EventEmitter<InlineEditorState>;
    onChange: EventEmitter<InternalEvent>;
    onFocus: EventEmitter<InternalEvent>;
    onBlur: EventEmitter<InternalEvent>;
    onKeyPress: EventEmitter<InternalEvent>;
    onEnter: EventEmitter<InternalEvent>;
    onEscape: EventEmitter<InternalEvent>;
    onSave: EventEmitter<InternalEvent>;
    onEdit: EventEmitter<InternalEvent>;
    onCancel: EventEmitter<InternalEvent>;
    onClick: EventEmitter<InternalEvent>;
    onUpdateConfig: EventEmitter<InlineConfig>;
}
export declare class ExternalEvents {
    onChange: EventEmitter<InlineEditorEvent>;
    onSave: EventEmitter<InlineEditorEvent>;
    onKeyPress: EventEmitter<InlineEditorEvent>;
    onFocus: EventEmitter<InlineEditorEvent>;
    onBlur: EventEmitter<InlineEditorEvent>;
    onEnter: EventEmitter<InlineEditorEvent>;
    onEscape: EventEmitter<InlineEditorEvent>;
    onEdit: EventEmitter<InlineEditorEvent>;
    onCancel: EventEmitter<InlineEditorEvent>;
    onClick: EventEmitter<InlineEditorEvent>;
    onError: EventEmitter<InlineEditorError | InlineEditorError[]>;
}
export interface InternalEvent {
    event?: Event;
    state: InlineEditorState;
}
export interface ExternalEvent {
    event?: Event;
    state: InlineEditorStateOptions;
}
export interface InlineEditorEvent extends ExternalEvent {
    instance: InlineEditorComponent;
}
