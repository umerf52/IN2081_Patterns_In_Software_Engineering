package de.tum.in.ase.pse;

public class CapturePhotoCommand implements Command {
    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    private Camera camera;


    public CapturePhotoCommand(Camera camera) {
        this.camera = camera;
    }

    @Override
    public void execute() {
        camera.takePicture();
    }
}
