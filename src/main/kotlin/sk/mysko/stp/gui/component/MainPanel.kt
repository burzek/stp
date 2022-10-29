package sk.mysko.stp.gui.component

import com.intellij.ui.components.JBPanel
import com.intellij.util.ui.components.BorderLayoutPanel
import javax.swing.JTextArea

class MainPanel(private val controller : StringToolsController) : BorderLayoutPanel() {

        private val controller :StringToolsController

        init {
            var inputText: InputTextEditor
            var outputText: JTextArea
            var statusLine: StatusLine
            initalizeGUI();
        }
        //private List<OperationSelector> operations = new ArrayList<>();



//        public void showWarning(ConversionData conversionData) {
//            inputText.showWarning(conversionData.isInvalidInput());
//            statusLine.updateErrorStatus(conversionData.getErrorMessageForInvalidInput());
//        }
//
//        public void setOutputContent(String content) {
//            outputText.setText(content);
//        }
//
//        public void setInputContent(String content) {
//            inputText.setText(content);
//        }
//
//        public String getInputContent() {
//            return inputText.getText();
//        }
//
//        public String getOutputContent() {
//            return outputText.getText();
//        }
//
//        public Operation getSelectedOperation() {
//            return operations.stream().filter(AbstractButton::isSelected).findFirst().map(OperationSelector::getOperation)
//                .orElseThrow(IllegalStateException::new);
//        }

        private fun initalizeGUI() {
//            GuiFactory guiFactory = new GuiFactory();
//            setLayout(new GridBagLayout());
//
//            //original text area
//            add(guiFactory.createLabel(ResourceKey.ORIGINAL_TEXT), guiFactory.getGridBagBuilder().withPos(0, 0).toGBC());
//            inputText = guiFactory.createInputTextEditor(controller);
//            add(inputText, guiFactory.getGridBagBuilder().withPos(1, 0).toGBC());
//
//            //converted text area
//            add(guiFactory.createLabel(ResourceKey.CONVERTED_TEXT), guiFactory.getGridBagBuilder().withPos(0, 1).toGBC());
//            outputText = guiFactory.createOutputTextField();
//            add(outputText, guiFactory.getGridBagBuilder().withPos(1, 1).toGBC());
//
//            //actions panel
//            final JPanel actionsPanel = guiFactory.createPanel(new GridLayout(1, 3));
//            //conversion actions
//            ButtonGroup buttonGroup = new ButtonGroup();
//            final JPanel radioPanel = guiFactory.createPanel(new VerticalLayout(0));
//            operations.add(guiFactory
//                .createOperationSelector(ResourceKey.STRING_TO_HEX_ACTION, Operation.STRING_TO_HEX, controller, buttonGroup));
//            operations.add(guiFactory
//                .createOperationSelector(ResourceKey.HEX_TO_STRING_ACTION, Operation.HEX_TO_STRING, controller, buttonGroup));
//            operations.add(guiFactory
//                .createOperationSelector(ResourceKey.STRING_TO_BINARY_ACTION, Operation.STRING_TO_BIN, controller, buttonGroup));
//            operations.add(guiFactory
//                .createOperationSelector(ResourceKey.BINARY_TO_STRING_ACTION, Operation.BIN_TO_STRING, controller, buttonGroup));
//            operations.add(guiFactory
//                .createOperationSelector(ResourceKey.STRING_TO_OCT_ACTION, Operation.STRING_TO_OCT, controller, buttonGroup));
//            operations.add(guiFactory
//                .createOperationSelector(ResourceKey.OCT_TO_STRING_ACTION, Operation.OCT_TO_STRING, controller, buttonGroup));
//            operations.forEach(radioPanel::add);
//            guiFactory.addBorder(radioPanel, ResourceKey.CONVERSION_TITLE);
//            actionsPanel.add(radioPanel);
//
//            //encoding actions
//            final JPanel radioPanel2 = guiFactory.createPanel(new VerticalLayout(0));
//            operations.add(guiFactory
//                .createOperationSelector(ResourceKey.BASE_64_ENCODE_ACTION, Operation.BASE_64_ENCODE, controller, buttonGroup));
//            operations.add(guiFactory
//                .createOperationSelector(ResourceKey.BASE_64_DECODE_ACTION, Operation.BASE_64_DECODE, controller, buttonGroup));
//            operations.add(guiFactory.createOperationSelector(ResourceKey.URL_ENCODE_ACTION, Operation.URL_ENCODE, controller, buttonGroup));
//            operations.add(guiFactory.createOperationSelector(ResourceKey.URL_DECODE_ACTION, Operation.URL_DECODE, controller, buttonGroup));
//            operations.add(guiFactory.createOperationSelector(ResourceKey.HTML_ENCODE_ACTION, Operation.HTML_ENCODE, controller, buttonGroup));
//            operations.add(guiFactory.createOperationSelector(ResourceKey.HTML_DECODE_ACTION, Operation.HTML_DECODE, controller, buttonGroup));
//            operations.subList(6, operations.size()).forEach(radioPanel2::add);
//            guiFactory.addBorder(radioPanel2, ResourceKey.CODING_TITLE);
//            actionsPanel.add(radioPanel2);
//
//            //other operations
//            final JPanel radioPanel3 = guiFactory.createPanel(new VerticalLayout(0));
//            operations.add(guiFactory.createOperationSelector(ResourceKey.ROT13_ACTION, Operation.ROT13, controller, buttonGroup));
//            operations.add(guiFactory.createOperationSelector(ResourceKey.MD5_HASH_ACTION, Operation.MD5_HASH, controller, buttonGroup));
//            operations.add(guiFactory.createOperationSelector(ResourceKey.SHA_256_ACTION, Operation.SHA256_HASH, controller, buttonGroup));
//            operations.add(guiFactory.createOperationSelector(ResourceKey.SHA_512_ACTION, Operation.SHA512_HASH, controller, buttonGroup));
//            operations.add(guiFactory.createOperationSelector(ResourceKey.CRC32_ACTION, Operation.CRC32, controller, buttonGroup));
//            operations.add(guiFactory
//                .createOperationSelector(ResourceKey.LUHN_DIGIT_GEN_ACTION, Operation.LUHN_DIGIT_GENERATOR, controller, buttonGroup));
//
//            operations.subList(12, operations.size()).forEach(radioPanel3::add);
//            guiFactory.addBorder(radioPanel3, ResourceKey.HASH_CRC_TITLE);
//            actionsPanel.add(radioPanel3);
//            add(actionsPanel, guiFactory.getGridBagBuilder().withPos(0, 3).withGridWidth(3).withAnchor(GridBagConstraints.CENTER).toGBC());
//
//            operations.get(0).setSelected(true);    //select first button
//
//            //add status line
//            statusLine = guiFactory.createStatusLine();
//            add(statusLine, guiFactory.getGridBagBuilder().withPos(0, 5).withAnchor(GridBagConstraints.CENTER).withGridWidth(2).toGBC());
//
//            //actions
//            JPanel buttonPanel = guiFactory.createPanel(new FlowLayout(FlowLayout.LEFT));
//            buttonPanel.add(guiFactory.createActionButton(ResourceKey.REPLACE_ACTION, new ReplaceInEditorAction(controller, statusLine)));
//            buttonPanel.add(guiFactory.createActionButton(ResourceKey.COPY_TO_CPB_ACTION, new CopyToClipboardAction(controller, statusLine)));
//            buttonPanel.add(guiFactory.createActionButton(ResourceKey.CLOSE_ACTION, new CloseAction(controller)));
//            add(buttonPanel,
//                guiFactory.getGridBagBuilder().withPos(0, 4).withFill(GridBagConstraints.VERTICAL).withAnchor(GridBagConstraints.WEST)
//                    .withGridWidth(2).toGBC());
//
        }
}