import React from "react";
import {
    StyleSheet,
    Text,
    View,
    Switch,
    TouchableOpacity,
    Image, Alert, ScrollView
} from "react-native";
import { Camera, Permissions } from "expo";

import vision from "react-cloud-vision-api";

'use strict'

// trained vision API --> ask Nico for API key
// vision.init({ auth: '' })

class HomeScreen extends React.Component {

    state = {
        switchValue: false,
        hasCameraPermission: null,
        type: Camera.Constants.Type.back,
        imageuri: "",
        photoHolder: "",
        url: "",
        text: "Testing",
        jsonText: ""
    };

    async componentWillMount() {
        const { status } = await Permissions.askAsync(Permissions.CAMERA);
        this.setState({ hasCameraPermission: status === "granted" });
    }


    cameraChange = () => {
        this.setState({
            imageuri: "",
            photoHolder: "",
            url: "",
            type:
                this.state.type === Camera.Constants.Type.back
                    ? Camera.Constants.Type.front
                    : Camera.Constants.Type.back
        });
    };

    snap = async () => {
        if (this.camera) {
            let photo = await this.camera.takePictureAsync({ base64: true });
            //req.image.img = photo;
            // this saves an object in the app which has a uri key
            // can get our image url from this result
            /*
            looks something like this:
              Object{
                "height": 34,
                "uri": "file://data.jpg"
                .
              }
            */
            //console.log(photo);
            if (photo) {
                // this sets the imageuri to the photo url was captured
                this.setState({ imageuri: photo.base64 });
                this.setState({ photoHolder: photo.uri });
            }
        }
    };

    buttonStuff() {
        this.setState({ imageuri: "" })
        this.setState({ jsonText: "" })
    }

    uploadToCloud = async () => {
        if (this.state.imageuri == "") {
            Alert.alert("You have nothing to upload")
        }
        else {
            this.setState({jsonText: "Getting results..."})
            // construct parameters
            const request = new vision.Request({
                image: new vision.Image({
                    // need to convert it to a string from a base64
                    base64: this.state.imageuri
                }),
                features: [
                    //new vision.Feature('LABEL_DETECTION', 100),
                    new vision.Feature('WEB_DETECTION', 500),
                    //can add additional features like logo_detection
                    //new vision.Feature('LOGO_DETECTION', 10),
                ]
            })

            // this changes the state of the json text to be the image url
            // this.setState({ jsonText: this.state.imageuri })
            // send single request
            console.log("here are your results\n");
        //console.log(result);

            vision.annotate(request).then((result) => {

                // console logs the entire json result
                console.log(result)
                let bestGuess = result["responses"][0]["webDetection"]["bestGuessLabels"][0]["label"]
                let one = result["responses"][0]["webDetection"]["webEntities"][0]["description"]
                let two = result["responses"][0]["webDetection"]["webEntities"][1]["description"]
                let three = result["responses"][0]["webDetection"]["webEntities"][2]["description"]

                console.log("best guess: " + bestGuess + "\n\n")
                console.log("other results: ")
                console.log(one + "\n" + two + "\n")

                this.setState({
                    jsonText:
                        "best guess: " + bestGuess + "\n\n" +
                        "other results: " + "\n" +
                        one + "\n" + two + "\n" + three
                })

                /*
                 // this is for logging the label_detection results (not used anymore as web_detection is more specific) //
                console.log(result["responses"][0]["labelAnnotations"][0]["description"]);
                console.log(result["responses"][0]["labelAnnotations"][1]["description"]);
                console.log(result["responses"][0]["labelAnnotations"][2]["description"]);
                console.log(result["responses"][0]["labelAnnotations"][3]["description"]);
                */

                // this is for outputting the labe_detection part (not being used anymore)
                //this.setState({ jsonText: result["responses"][0]["labelAnnotations"][0]["description"] + "\n" + result["responses"][0]["labelAnnotations"][1]["description"] + "\n" + result["responses"][0]["labelAnnotations"][2]["description"] + "\n" }) //result["responses"][0]["labelAnnotations"][3]["description"]})
            }, (e) => {
                console.log('Error: ', e)
            })
        }
    }

    render() {
        const { hasCameraPermission } = this.state;
        if (hasCameraPermission === null) {
            return <View />;
        } else if (hasCameraPermission === false) {
            return (
                <View>
                    <Text>No access to camera</Text>
                </View>
            );
        } else {
            return (
                <View style={styles.container}>

                    {/* switch to show the camera */}
                    <View style={styles.switchview}>
                        <Text style={{ color: "white", fontSize: 16, paddingBottom: 4, paddingTop: 5 }}>Show camera</Text>
                        <Switch
                            onValueChange={value => {
                                this.setState({ switchValue: value });
                            }}
                            value={this.state.switchValue}
                            style={styles.switch}
                        />
                    </View>
                    {/* end show camera */}

                    {/* if statement depicting what is shown on the screen...
          whether it be the camera preview or not
          */}
                    {this.state.switchValue ? (
                        <View style={styles.cameraview}>
                            {this.state.photoHolder != "" ? (
                                <Image
                                    source={{
                                        //uri: this.state.imageuri
                                        uri: this.state.photoHolder

                                    }}
                                    style={styles.uploadedImage}
                                    resizeMode="contain"
                                />
                            ) : (
                                    <Camera
                                        style={styles.camera}
                                        type={this.state.type}
                                        ref={ref => {
                                            this.camera = ref;
                                        }}
                                    >
                                        <View style={styles.camerabuttonview}>
                                            <TouchableOpacity
                                                style={styles.cameraButtons}
                                                onPress={this.cameraChange}
                                            >
                                                <Text
                                                    style={{
                                                        fontSize: 18,
                                                        marginBottom: 10,
                                                        color: "white"
                                                    }}
                                                >
                                                    Flip
                      </Text>
                                            </TouchableOpacity>
                                        </View>
                                    </Camera>
                                )}
                        </View>
                    ) : (
                            <View style={styles.cameraview}>
                                {this.state.url != "" ? (
                                    <Text>Uploaded url : {this.state.url}</Text>
                                ) : null}
                                <Text>Camera off</Text>
                            </View>
                        )}
                    {this.state.switchValue ? (
                        <View style={styles.buttonsView}>
                            {this.state.imageuri == "" ? (
                                <View style={styles.captureButtonView}>
                                    <TouchableOpacity
                                        style={styles.cameraButtons}
                                        onPress={this.snap}
                                    >
                                        <Text
                                            style={{ fontSize: 18, marginBottom: 10, color: "white" }}
                                        >
                                            Capture
                    </Text>
                                    </TouchableOpacity>
                                </View>
                            ) : null}

                            {/* upload button for the camera image
              - this calls the upload function --> need to change it so that we get the 
                API call function and put it through to Vision cloud
              */}

                            {/* reset button for the camera photoholder and imageuri
              allows the process to continue even after an intial
              photo is taken */}
                            <View style={styles.captureButtonView}>
                                <TouchableOpacity
                                    style={styles.cameraButtons}
                                    onPress={() => {
                                        this.setState({ photoHolder: "" });
                                        this.buttonStuff();
                                    }}>
                                    <Text style={{ fontSize: 18, marginBottom: 10, color: "white" }}>
                                        Reset
                </Text>
                                </TouchableOpacity>
                            </View>
                            <View style={styles.captureButtonView}>
                                <TouchableOpacity
                                    style={styles.cameraButtons}
                                    onPress={() => { this.uploadToCloud() }}           //  --> uploads data to vision cloud
                                >
                                    <Text
                                        style={{ fontSize: 18, marginBottom: 10, color: "white" }}
                                    >
                                        Upload
                  </Text>
                                </TouchableOpacity>
                            </View>
                        </View>
                    ) : null}
                    <ScrollView>
                        <View style={styles.textView}>
                            <Text style={{
                                color: "white",
                                fontSize: 20,
                                fontStyle: "italic"
                            }}>
                                Take a picture of a car!
                        </Text>
                            <Text style={{ color: "#ffffff", fontSize: 18 }}>
                                {this.state.jsonText}
                            </Text>
                        </View>
                    </ScrollView>
                </View>
            );

        }
    }
}
export default HomeScreen;

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: "#336dce",
        alignItems: "center",
        justifyContent: "flex-start"
    },
    switchview: {
        marginTop: 20,
        backgroundColor: "#336dce",
        padding: 10,
        alignItems: "center",
        borderRadius: 5,
        marginBottom: 5
    },
    switch: {
        padding: 5
    },
    cameraview: {
        height: 400,
        width: "90%",
        backgroundColor: "black",
        borderRadius: 5,
        justifyContent: "center",
        alignItems: "center",
        borderColor: "white"
    },
    camera: {
        height: "95%",
        width: "95%",
        backgroundColor: "white",
        borderRadius: 5,
        justifyContent: "center",
        alignItems: "center"
    },
    camerabuttonview: {
        height: "100%",
        backgroundColor: "transparent"
    },
    cameraButtons: {
        borderColor: "#fff",
        borderWidth: 2,
        padding: 10,
        borderRadius: 5,
        margin: 5
    },
    captureButtonView: {
        height: 75
    },
    buttonsView: {
        height: 75,
        width: "100%",
        flexDirection: "row",
        justifyContent: "center"
    },
    uploadedImage: {
        height: "90%",
        width: "90%",
        padding: 10
    },
    textView: {
        padding: 0
    }
});