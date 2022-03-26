package com.ssau.laboop.io;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssau.laboop.functions.factory.TabulatedFunctionFactory;
import com.ssau.laboop.tabulatedFunction.TabulatedFunction;
import com.ssau.laboop.tabulatedFunction.impl.ArrayTabulatedFunction;
import com.ssau.laboop.tabulatedFunction.impl.Point;
import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

final public class FunctionsIO {
    private FunctionsIO() {
        throw new UnsupportedOperationException("Создание объектов и наследование для данного класса невозможно");
    }

    static void writeTabulatedFunction(BufferedWriter writer, TabulatedFunction function) throws IOException {
        PrintWriter out = new PrintWriter(writer);
        out.println(function.getCount());
        for (Point point : function) {
            out.printf("%f %f\n", point.x, point.y);
        }
        writer.flush();
    }

    static void writeTabulatedFunction(BufferedOutputStream outputStream, TabulatedFunction function) throws IOException {
        DataOutputStream out = new DataOutputStream(outputStream);
        out.writeInt(function.getCount());
        for (Point point : function) {
            out.writeDouble(point.x);
            out.writeDouble(point.y);
        }
        outputStream.flush();
    }

    public static TabulatedFunction readTabulatedFunction(BufferedReader reader, TabulatedFunctionFactory factory) throws IOException {
        int count;
        try {
            count = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException | IOException nfe) {
            throw new IOException(nfe);
        }
        double[] xValues = new double[count];
        double[] yValues = new double[count];
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.forLanguageTag("ru"));
        String tempString;
        for (int i = 0; i < count; i++) {
            tempString = reader.readLine();
            try {
                xValues[i] = numberFormat.parse(tempString.split(" ")[0]).doubleValue();
                yValues[i] = numberFormat.parse(tempString.split(" ")[1]).doubleValue();
            } catch (ParseException pe) {
                throw new IOException(pe);
            }
        }
        return factory.create(xValues, yValues);
    }

    public static TabulatedFunction readTabulatedFunction(BufferedInputStream inputStream, TabulatedFunctionFactory factory) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        int count = dataInputStream.readInt();
        double[] xValues = new double[count];
        double[] yValues = new double[count];
        for (int i = 0; i < count; i++) {
            xValues[i] = dataInputStream.readDouble();
            yValues[i] = dataInputStream.readDouble();
        }
        return factory.create(xValues, yValues);
    }

    public static void serialize(BufferedOutputStream stream, TabulatedFunction function) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(stream);
        out.writeObject(function);
        stream.flush();
    }

    public static TabulatedFunction deserialize(BufferedInputStream stream) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(stream);
        return (TabulatedFunction) in.readObject();
    }

    public static void serializeXml(BufferedWriter writer, ArrayTabulatedFunction function) throws IOException {
        XStream xStream = new XStream();
        xStream.toXML(function, writer);
        writer.flush();
    }

    public static ArrayTabulatedFunction deserializeXml(BufferedReader reader) {
        XStream xStream = new XStream();
        return (ArrayTabulatedFunction) xStream.fromXML(reader);
    }

    public static void serializeJson(BufferedWriter writer, ArrayTabulatedFunction function) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            writer.write(objectMapper.writeValueAsString(function));
        } catch (JsonMappingException e) {
            throw new IOException(e);
        }
    }

    public static ArrayTabulatedFunction deserializeJson(BufferedReader reader) throws IOException {
        ObjectMapper stream = new ObjectMapper();
        return stream.readerFor(ArrayTabulatedFunction.class).readValue(reader);
    }


}
