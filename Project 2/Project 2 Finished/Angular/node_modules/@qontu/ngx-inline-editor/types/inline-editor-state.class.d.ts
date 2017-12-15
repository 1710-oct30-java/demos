export interface InlineEditorStateOptions {
    value: any;
    editing?: boolean;
    disabled?: boolean;
    empty?: boolean;
}
export declare class InlineEditorState {
    constructor({value, disabled, editing, empty}?: InlineEditorStateOptions);
    private empty;
    private value;
    private disabled;
    private editing;
    newState(state: InlineEditorState | InlineEditorStateOptions): InlineEditorState;
    getState(): InlineEditorStateOptions;
    clone(): InlineEditorState;
    isEmpty(): boolean;
    isEditing(): boolean;
    isDisabled(): boolean;
}
