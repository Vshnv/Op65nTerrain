package op65n.tech.terrain.common.perlin.type;

@SuppressWarnings("unused")
public abstract class NoiseGenerator {

    protected final int[] perm = new int[512];
    protected double offsetX;
    protected double offsetY;
    protected double offsetZ;

    /**
     * Computes and returns the 1D noise for the given coordinate in 1D space
     *
     * @param x X coordinate
     * @return Noise at given location, from range -1 to 1
     */
    public double noise(final double x) {
        return noise(x, 0, 0);
    }

    /**
     * Computes and returns the 2D noise for the given coordinates in 2D space
     *
     * @param x X coordinate
     * @param y Y coordinate
     * @return Noise at given location, from range -1 to 1
     */
    public double noise(final double x, final double y) {
        return noise(x, y, 0);
    }

    /**
     * Computes and returns the 3D noise for the given coordinates in 3D space
     *
     * @param x X coordinate
     * @param y Y coordinate
     * @param z Z coordinate
     * @return Noise at given location, from range -1 to 1
     */
    public abstract double noise(final double x, final double y, final double z);

    /**
     * Generates noise for the 1D coordinates using the specified number of
     * octaves and parameters
     *
     * @param x         X-coordinate
     * @param octaves   Number of octaves to use
     * @param frequency How much to alter the frequency by each octave
     * @param amplitude How much to alter the amplitude by each octave
     * @return Resulting noise
     */
    public double noise(final double x, final int octaves, final double frequency, final double amplitude) {
        return noise(x, 0, 0, octaves, frequency, amplitude);
    }

    /**
     * Generates noise for the 1D coordinates using the specified number of
     * octaves and parameters
     *
     * @param x          X-coordinate
     * @param octaves    Number of octaves to use
     * @param frequency  How much to alter the frequency by each octave
     * @param amplitude  How much to alter the amplitude by each octave
     * @param normalized If true, normalize the value to [-1, 1]
     * @return Resulting noise
     */
    public double noise(final double x, final int octaves, final double frequency, final double amplitude, final boolean normalized) {
        return noise(x, 0, 0, octaves, frequency, amplitude, normalized);
    }

    /**
     * Generates noise for the 2D coordinates using the specified number of
     * octaves and parameters
     *
     * @param x         X-coordinate
     * @param y         Y-coordinate
     * @param octaves   Number of octaves to use
     * @param frequency How much to alter the frequency by each octave
     * @param amplitude How much to alter the amplitude by each octave
     * @return Resulting noise
     */
    public double noise(final double x, final double y, final int octaves, final double frequency, final double amplitude) {
        return noise(x, y, 0, octaves, frequency, amplitude);
    }

    /**
     * Generates noise for the 2D coordinates using the specified number of
     * octaves and parameters
     *
     * @param x          X-coordinate
     * @param y          Y-coordinate
     * @param octaves    Number of octaves to use
     * @param frequency  How much to alter the frequency by each octave
     * @param amplitude  How much to alter the amplitude by each octave
     * @param normalized If true, normalize the value to [-1, 1]
     * @return Resulting noise
     */
    public double noise(final double x, final double y, final int octaves, final double frequency, final double amplitude, final boolean normalized) {
        return noise(x, y, 0, octaves, frequency, amplitude, normalized);
    }

    /**
     * Generates noise for the 3D coordinates using the specified number of
     * octaves and parameters
     *
     * @param x         X-coordinate
     * @param y         Y-coordinate
     * @param z         Z-coordinate
     * @param octaves   Number of octaves to use
     * @param frequency How much to alter the frequency by each octave
     * @param amplitude How much to alter the amplitude by each octave
     * @return Resulting noise
     */
    public double noise(final double x, final double y, final double z, final int octaves, final double frequency, final double amplitude) {
        return noise(x, y, z, octaves, frequency, amplitude, false);
    }

    /**
     * Generates noise for the 3D coordinates using the specified number of
     * octaves and parameters
     *
     * @param x          X-coordinate
     * @param y          Y-coordinate
     * @param z          Z-coordinate
     * @param octaves    Number of octaves to use
     * @param frequency  How much to alter the frequency by each octave
     * @param amplitude  How much to alter the amplitude by each octave
     * @param normalized If true, normalize the value to [-1, 1]
     * @return Resulting noise
     */
    public double noise(final double x, final double y, final double z, final int octaves, final double frequency, final double amplitude, final boolean normalized) {
        double result = 0;
        double amp = 1;
        double freq = 1;
        double max = 0;

        for (int index = 0; index < octaves; index++) {
            result += noise(x * freq, y * freq, z * freq) * amp;
            max += amp;
            freq *= frequency;
            amp *= amplitude;
        }

        if (normalized) {
            result /= max;
        }

        return result;
    }

}
